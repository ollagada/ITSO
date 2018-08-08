package kh.spring.dto;


public class TipDTO {

	int tip_seq;
	String tip_title;
	String tip_contents;
	int tip_writer;
	String tip_date;
	String tip_viewcount;
	String category;
	
	public int getTip_seq() {
		return tip_seq;
	}
	public void setTip_seq(int tip_seq) {
		this.tip_seq = tip_seq;
	}
	public String getTip_title() {
		return tip_title;
	}
	public void setTip_title(String tip_title) {
		this.tip_title = tip_title;
	}
	public String getTip_contents() {
		return tip_contents;
	}
	public void setTip_contents(String tip_contents) {
		this.tip_contents = tip_contents;
	}
	public int getTip_writer() {
		return tip_writer;
	}
	public void setTip_writer(int tip_writer) {
		this.tip_writer = tip_writer;
	}
	public String getTip_date() {
		return tip_date;
	}
	public void setTip_date(String tip_date) {
		this.tip_date = tip_date;
	}
	public String getTip_viewcount() {
		return tip_viewcount;
	}
	public void setTip_viewcount(String tip_viewcount) {
		this.tip_viewcount = tip_viewcount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public TipDTO(int tip_seq, String tip_title, String tip_contents, int tip_writer, String tip_date,
			String tip_viewcount, String category) {
		super();
		this.tip_seq = tip_seq;
		this.tip_title = tip_title;
		this.tip_contents = tip_contents;
		this.tip_writer = tip_writer;
		this.tip_date = tip_date;
		this.tip_viewcount = tip_viewcount;
		this.category = category;
	}
	
	public TipDTO() {
	}


	
}
	