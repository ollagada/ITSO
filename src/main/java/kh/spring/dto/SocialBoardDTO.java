package kh.spring.dto;

import java.sql.Date;

public class SocialBoardDTO {
	private int collection_seq;
	private int social_seq;
	private String social_title;
	private String social_contents;
	private int social_writer;
	private String writerName;
	private Date social_date;
	private String photo;
	private int age;
	private String gender;
	
	
	public SocialBoardDTO() {
		super();
	}
	
	
	public SocialBoardDTO(int social_seq, String social_title, String social_contents, int social_writer,
			String social_date, String photo,int age,String gender) {
		super();
		this.social_seq = social_seq;
		this.social_title = social_title;
		this.social_contents = social_contents;
		this.social_writer = social_writer;
		this.social_date = social_date;
		this.photo = photo;
		this.age = age;
		this.gender = gender;
	}
	public SocialBoardDTO(int age,String gender,int social_seq) {
		this.age = age;
		this.gender = gender;
		this.social_seq =social_seq;
	}
	
	

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getSocial_seq() {
		return social_seq;
	}
	
	public void setSocial_seq(int social_seq) {
		this.social_seq = social_seq;
	}
	
	public String getSocial_title() {
		return social_title;
	}
	
	public void setSocial_title(String social_title) {
		this.social_title = social_title;
	}
	
	public String getSocial_contents() {
		return social_contents;
	}
	
	public void setSocial_contents(String social_contents) {
		this.social_contents = social_contents;
	}
	
	public int getSocial_writer() {
		return social_writer;
	}
	
	public void setSocial_writer(int social_writer) {
		this.social_writer = social_writer;
	}
	
	public Date getSocial_date() {
		return social_date;
	}
	
	public void setSocial_date(Date social_date) {
		this.social_date = social_date;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getSocial_gender() {
		return social_gender;
	}
	
	public void setSocial_gender(String social_gender) {
		this.social_gender = social_gender;
	}
	
	public int getSocial_age() {
		return social_age;
	}
	
	public void setSocial_age(int social_age) {
		this.social_age = social_age;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	
	
}
