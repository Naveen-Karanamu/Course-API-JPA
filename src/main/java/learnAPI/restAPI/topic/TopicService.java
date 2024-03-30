package learnAPI.restAPI.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	List<Topic> topics = new ArrayList<>(
			Arrays.asList(
					new Topic(1, "Spring","Spring Description"),
					new Topic(2, "Java","Java Description"),
					new Topic(3, "Web","Web Description")
					)
			);
	
	
//	GET
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		
		return topics;
	}
	
	public Optional<Topic> getTopic(int id) {
		
		Optional<Topic> topic=topicRepository.findById(id);
		return topic;
	}
	
//	POST
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
//	PUT
	public Topic updateTopic(Topic topic) {
		
		Topic updatedTopic= topicRepository.save(topic);
		return updatedTopic;
	}
	
	
//DELETE
	public void deleteTopic(Integer id) {
		
		topicRepository.deleteById(id);
	}


}
