package kh.spring.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;
import kh.spring.dto.ReportDTO;
import kh.spring.dto.SearchedTipDTO;
import kh.spring.dto.TipCommentDTO;
import kh.spring.dto.TipDTO;
import kh.spring.dto.TipGoodDTO;
import kh.spring.interfaces.ITipDAO;

@Repository
public class TipDAOImpl implements ITipDAO {

	@Autowired
	SqlSessionTemplate template;

	@Override
	public int insertTipData(TipDTO dto) {

		return template.insert("TipBoard.insertData", dto);
	}

	@Override
	public List<TipDTO> getBeautyTipData() {
		// TODO Auto-generated method stub
		return template.selectList("TipBoard.getBeautyTipData");
	}

	@Override
	public List<TipDTO> getDietTipData() {
		// TODO Auto-generated method stub
		return template.selectList("TipBoard.getDietTipData");
	}

	@Override
	public List<TipDTO> getFashionTipData() {
		// TODO Auto-generated method stub
		return template.selectList("TipBoard.getFashionTipData");
	}

	@Override
	public List<TipDTO> getETCTipData() {
		return template.selectList("TipBoard.getETCTipData");
	}

	@Override
	public int deleteTipData(TipDTO dto) {
		return 0;
	}

	@Override
	public int updateTipData(TipDTO dto) {
		return 0;
	}

	@Override
	public List<TipDTO> getSpecificTipView(int seq) {
		return template.selectList("TipBoard.getSpecificTipView", seq);
	}
	@Override
	public List<TipGoodDTO> getTipLikeCounts(int seq) {

		return template.selectList("TipGood.getTipLikeCounts", seq);
	}
	@Override
	public int viewCountPlus(int seq) {
		return template.update("TipBoard.viewCountPlus", seq);
	}

	@Override
	public int tipArticleLikeProc(int seq, int tipLikingUser) {
		Map<String,Integer> map = new HashMap();
		map.put("seq", seq);
		map.put("tipLikingUser", tipLikingUser);
		return template.insert("TipBoard.tipArticleLikeProc", map);
	}
	
	@Override
	public List<TipDTO> getUpvotingArticles() {
		return template.selectList("TipBoard.getUpvotingArticles");
	}

	@Override
	public int insertTipCommentProc(TipCommentDTO dto) {
		
		return template.insert("TipComment.insertTipCommentProc",dto);
	}

	@Override
	public List<TipCommentDTO> getCommentsFromTip(int seq) {
		return template.selectList("TipComment.getCommentsFromTip",seq);
	}

	@Override
	public int deleteSpecificTip(int tipSeq) {
		return template.delete("TipBoard.deleteSpecificTip",tipSeq);
	}

	@Override
	public List<TipGoodDTO> isThisLikeWhetherFirst(int tipSeq, int tipLikingUser) {
		Map<String, Integer> map = new HashMap();
		map.put("tipSeq",tipSeq);
		map.put("tipLikingUser", tipLikingUser);
		return template.selectList("TipGood.isThisLikeWhetherFirst",map);
	}

	@Override
	public int deleteTipComment(int seq) {
		return template.delete("TipComment.deleteTipComment",seq);
	}

	@Override
	public int tipModifyProc(TipDTO dto) {
		return template.update("TipBoard.tipModifyProc",dto);
	}

	@Override
	public List<SearchedTipDTO> getSearchedTipList(String word) {
		return template.selectList("TipBoard.searchedTipBoard", word);
	}

	@Override
	public List<TipDTO> getTipBoardList(String category) {
		return template.selectList("TipBoard.getTipBoardList",category);
	}

	@Override
	public int getTipBoardCount(String category) {
		return template.selectOne("TipBoard.getTipBoardCount", category);
	}

	@Override
	public List<TipDTO> getTipBoardListRange(String category, int start, int end) {
		Map<String,String> map = new HashMap<>();
		map.put("category",category);
		map.put("start", start+"");
		map.put("end", end+"");
		return template.selectList("TipBoard.getTipBoardListRange", map);
	}

	@Override
	public List<TipDTO> getMyTipBoardList(MemberDTO dto) {
		return template.selectList("TipBoard.getMyTipBoardList", dto);
	}

	@Override
	public int insertReport(ReportDTO dto) {
		return template.insert("Report.reportArticle", dto);
	}

	@Override
	public List<ReportDTO> checkReportData(ReportDTO dto) {
		System.out.println(dto.getBoard_seq());
		return template.selectList("Report.checkArticle");
	}
}
