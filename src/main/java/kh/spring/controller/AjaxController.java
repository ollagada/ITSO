package kh.spring.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import kh.spring.dto.CollectionDTO;
import kh.spring.dto.FollowDTO;
import kh.spring.dto.GoodDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.NotificationDTO;
import kh.spring.dto.SocialBoardDTO;
import kh.spring.interfaces.IMemberService;
import kh.spring.interfaces.INotificationService;
import kh.spring.interfaces.ISocialBoardService;
import kh.spring.websocket.EchoHandler;

@Controller
public class AjaxController {
	@Autowired
	private IMemberService service;
	@Autowired
	private ISocialBoardService sservice;

	@Autowired
	private INotificationService noservice;

	@Autowired
	private ISocialBoardService sbService;



	@RequestMapping("/emailcheck.ajax")
	public @ResponseBody String emailExist(String email,HttpServletResponse response) {
		
		List<MemberDTO> emailcheck = service.emailExist(email);
		String msg =null;

		
		if(emailcheck.size()==0) {
		
			msg= "fa fa-check prefix";

		}else {
			System.out.println("실패");
			msg= "fa fa-close prefix";
		}

		try {
			URLEncoder.encode(msg,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping("/notificaiton.ajax")
	public @ResponseBody String notifiNavi(int user_seq,HttpSession session,NotificationDTO dto,HttpServletResponse response){
		try {
			int sessionSeq = ((MemberDTO)session.getAttribute("user")).getSeq();
			if(user_seq == sessionSeq) {
				NotificationDTO ndto = new NotificationDTO(sessionSeq);
				List<NotificationDTO> notiList = this.noservice.selectNotification(ndto);
				ObjectMapper mapper = new ObjectMapper();	
					
				String jsonString = mapper.writeValueAsString(notiList);					
				return jsonString;
   			   
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
	}
	
	
	@RequestMapping("/mainHeart.ajax")
	public @ResponseBody int mainHeart(int social_seq,int social_writer,HttpServletResponse response,HttpSession session) {				
		int user_seq = ((MemberDTO)session.getAttribute("user")).getSeq();
		GoodDTO gdto = new GoodDTO(social_seq,user_seq);

		int goodCount = sbService.selectGoodCount(gdto);
	

		if(goodCount>0) {
			int delete = sbService.deleteGoodCount(gdto);
		}else {
			int insert = sbService.insertGoodCount(gdto);

			if(user_seq != social_writer) {
				NotificationDTO nodto = new NotificationDTO(social_writer,user_seq,"good","좋아요를 눌렀습니다.","n","아무거나",social_seq);
				List<NotificationDTO> data = noservice.notificationData(nodto);
			

				try {
				
					if(data.size()==0) {
						int noInsert = noservice.insertNotification(nodto);
					
						NotificationDTO list = noservice.selectNotification(nodto).get(0);		
						System.out.println(list.getNoti_date());
						ObjectMapper mapper = new ObjectMapper();
						String jsonString  = mapper.writeValueAsString(list);	
						System.out.println(jsonString);
						EchoHandler.users.get(nodto.getUser_seq()).getBasicRemote().sendText(jsonString);
					}else {
						System.out.println("있음");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}				


		}

		int count = sbService.allGoodCount(gdto);
		System.out.println("작성자"+social_writer);
		System.out.println("게시물번호"+social_seq);
		System.out.println("누른사람 번호"+user_seq);
		return count;
	}


	@RequestMapping("/saveCollection.ajax")
	public @ResponseBody Object saveCollection(int collection_seq, int social_seq, HttpSession session) {
		System.out.println("ajax:"+collection_seq+":"+social_seq);
		SocialBoardDTO dto = new SocialBoardDTO();
		dto.setCollection_seq(collection_seq);
		dto.setSocial_seq(social_seq);

		List<SocialBoardDTO> list = sservice.selectCollectionContent(dto);	// 테이블에 있는지

		SocialBoardDTO result = null;
		if(list.size() > 0) {
			int delete = sservice.deleteCollectionContent(dto);
			System.out.println(delete>0?"delete성공":"delete실패");
		}else {
			int insert = sservice.insertCollectionContent(dto);
			System.out.println("결과: " + insert);
			System.out.println(insert>0?"insert성공":"insert실패");
			result = sservice.selectSocialBoard(social_seq);
		}
		return result;
	}

	@RequestMapping("/createCollection.ajax")
	public @ResponseBody String createCollection(String collection_title, String collection_contents, HttpSession session) {
		int seq = ((MemberDTO)session.getAttribute("user")).getSeq();
		CollectionDTO dto = new CollectionDTO();
		dto.setCollection_title(collection_title);
		dto.setCollection_contents(collection_contents);
		dto.setCollection_writer(seq);
		System.out.println(dto.getCollection_title()+":"+dto.getCollection_contents());
		int result = sservice.insertCollection(dto);
		String resultmsg = result>0?"생성성공":"생성실패";
		System.out.println(resultmsg);
		
		dto = sservice.getCollectionSeq(dto);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString="";
		try {
			jsonString = mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

	@RequestMapping("/removeCollection.ajax")
	public @ResponseBody void removeCollection(int collection_seq) {
		CollectionDTO dto = new CollectionDTO();
		dto.setCollection_seq(collection_seq);
		int result = sservice.deleteCollection(dto);
		String resultmsg = result>0?"삭제성공":"삭제실패";
		System.out.println(resultmsg);
	}

	@RequestMapping("/editCollection.ajax")
	public @ResponseBody void editCollection(CollectionDTO dto) {
		System.out.println(dto.getCollection_seq()+":"+dto.getCollection_title());
		int result = sservice.updateCollection(dto);
		String resultmsg = result>0?"수정성공":"수정실패";
		System.out.println(resultmsg);
	}

	@RequestMapping("/followUser.ajax")
	public @ResponseBody String followProc(int seq, String text, HttpSession session, HttpServletResponse resp) {
		FollowDTO dto = new FollowDTO();
		int user_seq = ((MemberDTO)session.getAttribute("user")).getSeq();

		dto.setUser_seq(user_seq);
		dto.setFollowing_seq(seq);

		System.out.println("text:" + text);
		String resultmsg = "";
		if(text.contains("언팔로우")) {
			int result = service.deleteFollowData(dto);
			resultmsg = result>0?"언팔로우성공":"언팔로우실패";
			System.out.println(resultmsg);
		} else {
			int result = service.insertFollowData(dto);
			resultmsg = result>0?"팔로우성공":"팔로우실패";
			System.out.println(resultmsg);
		}
		return resultmsg;
	}
	
	@RequestMapping("/fbLogin.ajax")
	public @ResponseBody String fbLogin(String data, HttpSession session) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = new HashMap<String, String>();
		String returnstr;
		try {
			map = mapper.readValue(data, new TypeReference<Map<String, String>>(){});
			
			MemberDTO dto = new MemberDTO();
			dto.setName(map.get("name"));
			dto.setEmail(map.get("email"));
			dto.setPw(" ");
			dto.setPart("facebook");
			dto.setBlock("n");
			dto.setState(" ");
			dto.setPhoto("background.jpg");
			dto.setWithdrawal("n");
			dto.setAge(0);
			dto.setGender(" ");
			
			List<MemberDTO> list = service.loginExist(dto);
			
			if(list.size()>0) {
				System.out.println("페북 로그인 성공");
				session.setMaxInactiveInterval(60*60);
				MemberDTO user = list.get(0);
				session.setAttribute("user", user);
				returnstr = "main.go";
			} else {
				int result = service.insertUserData(dto);
				System.out.println(result>0?"페북 가입 성공":"페북 가입 실패");
				returnstr = "main.go";
			}
			
			return returnstr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
