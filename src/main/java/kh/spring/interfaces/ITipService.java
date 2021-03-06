package kh.spring.interfaces;

import java.util.List;

import kh.spring.dto.MemberDTO;
import kh.spring.dto.ReportDTO;
import kh.spring.dto.SearchedTipDTO;
import kh.spring.dto.TipCommentDTO;
import kh.spring.dto.TipDTO;
import kh.spring.dto.TipGoodDTO;

public interface ITipService {

	public int insertTipData(TipDTO dto);

	public List<TipDTO> getBeautyTipData();

	public List<TipDTO> getDietTipData();

	public List<TipDTO> getFashionTipData();

	public List<TipDTO> getETCTipData();

	public List<TipDTO> getSpecificTipView(int seq);

	public List<TipDTO> getUpvotingArticles();


	public int updateTipData(TipDTO dto);

	public int deleteSpecificTip(int tipSeq);

	public int viewCountPlus(int seq);


	public int insertTipCommentProc(TipCommentDTO dto);


	
	public List<TipGoodDTO> isThisLikeWhetherFirst(int tipSeq, int tipLikingUser);

	public int tipArticleLikeProc(int seq, int tipLikingUser);

	public List<TipGoodDTO> getTipLikeCounts(int seq);

	public List<TipCommentDTO> getCommentsFromTip(int seq);

	public int deleteTipComment(int seq);


	public int tipModifyProc(TipDTO dto);
	
	public List<SearchedTipDTO> getSearchedTipList(String word);
	public List<TipDTO> getTipBoardList(String category);
	public int getTipBoardCount(String category);
	public List<TipDTO> getTipBoardListRange(String category, int start, int end);
	public List<TipDTO> getMyTipBoardList(MemberDTO dto);
	
	public int insertReport(ReportDTO dto);
	public List<ReportDTO> checkReportData(ReportDTO dto);
}
