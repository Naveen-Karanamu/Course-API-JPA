package learnAPI.restAPI.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
//	GET
	@GetMapping("/get/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@GetMapping("/get/topic/{id}")
	public ResponseEntity<Optional<Topic>> getTopic(@PathVariable Integer id) {
	    Optional<Topic> topic = topicService.getTopic(id);
	    if (topic != null) {
	        return ResponseEntity.ok(topic);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
//	POST
	@PostMapping("/post/topic")
	public List<Topic> addNewTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return topicService.getAllTopics();
	}
	
//	PUT
	@PutMapping("/update/topic/{id}")
	public ResponseEntity<Topic> updateTopic(@PathVariable Integer id, @RequestBody Topic topic) {
	    Topic newTopic = topicService.updateTopic(topic);
	    if (topic != null) {
	        return ResponseEntity.ok(newTopic);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
//	DELETE
	@DeleteMapping("/delete/topic/{id}")
	public void del(@PathVariable Integer id) {
	   topicService.deleteTopic(id);
	}
	
}
