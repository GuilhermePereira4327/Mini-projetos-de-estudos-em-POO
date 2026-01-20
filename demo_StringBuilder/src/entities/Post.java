package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
	
	private static DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime momment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> comment = new ArrayList<>();
	
	public Post() {
	}

	public Post(LocalDateTime momment, String title, String content, Integer likes) {
		this.momment = momment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public LocalDateTime getMomment() {
		return momment;
	}

	public void setMomment(LocalDateTime momment) {
		this.momment = momment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void addComment(Comment comment) {
		this.comment.add(comment);
	}
	
	public void removeComment(Comment comment) {
		this.comment.remove(comment);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes);
		sb.append(" likes - ");
		sb.append(FMT.format(momment) + "\n" );
		sb.append(content + "\n");
		sb.append("Comments: \n");
		for(Comment c: comment) {
			sb.append(c.getText() + "\n");
		}
		return sb.toString();
	}

}
