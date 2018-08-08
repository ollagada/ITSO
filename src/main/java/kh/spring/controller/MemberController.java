package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.MemberDTO;
import kh.spring.interfaces.IMemberService;

@Controller

public class MemberController {
	@Autowired
	private IMemberService service;
	
	@RequestMapping("/login.do")
	
	public ModelAndView login(MemberDTO dto,HttpSession session) {
		System.out.println(dto.getEmail()+":"+dto.getPw());
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> result = service.loginExist(dto);
		mav.addObject("result",result.size());
		if(result.size()>0) {
			session.setMaxInactiveInterval(60*60);
			session.setAttribute("sessionEmail", dto.getEmail());
			System.out.println(dto.getEmail());
		}
		System.out.println(result);
		mav.setViewName("loginProc.jsp");
		return mav;
	}
}
