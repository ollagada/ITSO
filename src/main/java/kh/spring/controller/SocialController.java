package kh.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import kh.spring.dto.CollectionDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.SocialBoardDTO;
import kh.spring.interfaces.ISocialBoardService;

@Controller
public class SocialController {
	@Autowired
	private ISocialBoardService service;

	@RequestMapping("/main.go")
	public ModelAndView showSocialBoardList(HttpSession session, HttpServletRequest request) {
		List<SocialBoardDTO> result = this.service.showSocialBoardList();
		ModelAndView mav = new ModelAndView();
		try {
			System.out.println(((MemberDTO)session.getAttribute("user")).getSeq());
			List<CollectionDTO> collectionList = this.service.getCollectionList((MemberDTO)session.getAttribute("user"));
			List<SocialBoardDTO> photoList = this.service.getCollectionPhotoList((MemberDTO)session.getAttribute("user"));

			mav.addObject("collectionList",collectionList);
			mav.addObject("photoList",photoList);
		}catch(NullPointerException e) {
			System.out.println("로그인x");
		}finally {
			mav.addObject("socialList",result);
			mav.setViewName("main3.jsp");
		}
		return mav;
	}
	
	@RequestMapping("/collection.go")
	public ModelAndView showCollectionList(int seq) {
		CollectionDTO dto = new CollectionDTO();
		dto.setCollection_seq(seq);
		List<CollectionDTO> clist = service.getCollectionData(dto);
		List<SocialBoardDTO> list = service.getCollectionSocialList(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("collectionList", clist);
		mav.addObject("socialList", list);
		mav.setViewName("collection.jsp");
		return mav;
	}
	
}
