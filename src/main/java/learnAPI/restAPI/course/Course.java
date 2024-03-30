package learnAPI.restAPI.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import learnAPI.restAPI.topic.Topic;

@Entity
public class Course {

	@Id
	private Integer id;
	private String name;
	private String description;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
		
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Course(Integer id, String name, String description, Integer topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic=new Topic(topicId, "", "");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
