package kh.spring.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;
import kh.spring.interfaces.IMemberDAO;

@Repository
public class MemberDAOImpl implements IMemberDAO{
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<MemberDTO> loginExist(MemberDTO dto) {
		
	return template.selectList("Member.selectData",dto);

/*		System.out.println("pw" + dto.getPw());
		return template.selectList("selectData",dto);*/
	}

	@Override
	public int insertUserData(MemberDTO dto) {
		return template.insert("Member.insertData",dto);
	}

	@Override
	public int updateUserData(MemberDTO dto) {
		return template.update("Member.updateData",dto);
	}

	@Override
	public int deleteUserData(MemberDTO dto) {
		return 0;
	}

	@Override
	public List<MemberDTO> emailExist(String email) {
		return template.selectList("Member.emailExist",email);
	}

}
