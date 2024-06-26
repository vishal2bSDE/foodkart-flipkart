package main.java.domain;

public class Rating {

	private String userId;
	private String comment;
	private int rate;
	
	
	
	public Rating(String userId, String comment, int rate) {
		super();
		this.userId = userId;
		this.comment = comment;
		this.rate = rate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
