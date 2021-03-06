package kh.spring.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dto.CollectionDTO;
import kh.spring.dto.GoodDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.SocialBoardDTO;
import kh.spring.interfaces.ISocialBoardDAO;
import kh.spring.interfaces.ISocialBoardService;

@Service
public class SocialBoardServiceImpl implements ISocialBoardService{
	
	@Autowired
	private ISocialBoardDAO dao;

	@Override
	public List<SocialBoardDTO> showSocialBoardList(SocialBoardDTO sdto) {
		System.out.println(sdto.getAge()+":"+sdto.getGender());
		return this.dao.showSocialBoardList(sdto);
	}

	@Override
	public int insertSocialBoard(SocialBoardDTO sdto) {
		return this.dao.insertSocialBoard(sdto);
	}

	@Override
	public int updateSocialBoard(SocialBoardDTO sdto) {
		return this.dao.updateSocialBoard(sdto);
	}

	@Override
	public int deleteSocialBoard(int seq) {
		return this.dao.deleteSocialBoard(seq);
	}
	
	@Override
	public int getSocialBoardcurrval() {
		return this.dao.getSocialBoardcurrval();
	}

	@Override
	public SocialBoardDTO selectSocialBoard(int seq) {
		return this.dao.selectSocialBoard(seq);
	}

	@Override
	public List<CollectionDTO> getCollectionList(MemberDTO dto) {
		return this.dao.getCollectionList(dto);
	}

	@Override
	public List<SocialBoardDTO> getCollectionPhotoList(MemberDTO dto) {
		return this.dao.getCollectionPhotoList(dto);
	}
	
	//醫뗭븘�슂
	@Override
	public Integer selectGoodCount(GoodDTO gdto) {
		return this.dao.selectGoodCount(gdto);
	}

	@Override
	public int insertGoodCount(GoodDTO gdto) {
		return this.dao.insertGoodCount(gdto);
	}

	@Override
	public int deleteGoodCount(GoodDTO gdto) {
		return this.dao.deleteGoodCount(gdto);
	}

	@Override
	public int allGoodCount(GoodDTO gdto) {
		return this.dao.allGoodCount(gdto);
	}

	@Override
	public List<SocialBoardDTO> getMyGoodSocialList(MemberDTO dto) {
		return this.dao.getMyGoodSocialList(dto);
	}
	
	//게시물 인기
	@Override
	public List<SocialBoardDTO> showSocialHotBoardList(SocialBoardDTO sdto) {
		return this.dao.showSocialHotBoardList(sdto);
	}
	
	//게시물 최신
	@Override
	public List<SocialBoardDTO> showSocialFollowBoardList(SocialBoardDTO sdto) {
		return this.dao.showSocialFollowBoardList(sdto);
	}

	@Override
	public List<SocialBoardDTO> getMySocialList(MemberDTO dto) {
		return this.dao.getMySocialList(dto);
	}

	@Override
	public List<SocialBoardDTO> getCollectionSocialList(int seq, int startCount, int endCount) {
		return this.dao.getCollectionSocialList(seq, startCount, endCount);
	}

	@Override
	public List<CollectionDTO> getCollectionData(CollectionDTO dto) {
		return this.dao.getCollectionData(dto);
	}

	@Override
	public int selectSocialWriter(int seq) {
		return this.dao.selectSocialWriter(seq);
	}
	@Override
	public int insertCollectionContent(SocialBoardDTO dto) {
		return this.dao.insertCollectionContent(dto);
	}
	
	@Override
	public int deleteCollectionContent(SocialBoardDTO dto) {
		return this.dao.deleteCollectionContent(dto);
	}

	@Override
	public List<SocialBoardDTO> selectCollectionContent(SocialBoardDTO dto) {
		return this.dao.selectCollectionContent(dto);
	}

	@Override
	public int insertCollection(CollectionDTO dto) {
		return this.dao.insertCollection(dto);
	}

	@Override
	public int deleteCollection(CollectionDTO dto) {
		return this.dao.deleteCollection(dto);
	}

	@Override
	public int updateCollection(CollectionDTO dto) {
		return this.dao.updateCollection(dto);
	}

	@Override
	public CollectionDTO getCollectionSeq(CollectionDTO dto) {
		return this.dao.getCollectionSeq(dto);
	}
	
	@Override
	public CollectionDTO getCollectionInfo(CollectionDTO dto) {
		return this.dao.getCollectionInfo(dto);
	}

	
	@Override
	public List<SocialBoardDTO> showHashTagBoardList(int pAge, String pGender, int user_seq, String search) {
		return this.dao.showHashTagBoardList(pAge, pGender, user_seq, search);
	}

	@Override
	public List<SocialBoardDTO> showHashTagHotBoardList(int pAge, String pGender, int user_seq, String search) {
		return this.dao.showHashTagHotBoardList(pAge, pGender, user_seq, search);
	}

	@Override
	public List<SocialBoardDTO> showHashTagFollowBoardList(int pAge, String pGender, int user_seq, String search) {
		return this.dao.showHashTagFollowBoardList(pAge, pGender, user_seq, search);
	}

	@Override
	public List<SocialBoardDTO> getMyGoodSocialArticleList(MemberDTO dto) {
		return this.dao.getMyGoodSocialArticleList(dto);
	}

	@Override
	public List<SocialBoardDTO> getsearchedTagSocialList(String word) {
		return this.dao.getsearchedTagSocialList(word);
	}

	@Override
	public List<CollectionDTO> getSearchedCollectionList(String word) {
		return this.dao.getSearchedCollectionList(word);
	}

	@Override
	public List<SocialBoardDTO> getSearchedCollectionPhotoList(String word) {
		return this.dao.getSearchedCollectionPhotoList(word);
	}

	@Override
	public Integer getCollectionCount(CollectionDTO dto) {
		return this.dao.getCollectionCount(dto);
	}

	@Override
	public List<SocialBoardDTO> getSearchedBrandList(String word) {
		return this.dao.getSearchedBrandList(word);
	}
}
