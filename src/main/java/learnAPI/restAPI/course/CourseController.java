package learnAPI.restAPI.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import learnAPI.restAPI.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
//	GET
	@GetMapping("/get/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable Integer id) {
		return courseService.getAllCourses(id);
	}
	
	@GetMapping("/get/topic/{topicId}/courses/{id}")
	public ResponseEntity<Optional<Course>> getCourse(@PathVariable Integer id) {
	    Optional<Course> course = courseService.getCourse(id);
	    if (course != null) {
	        return ResponseEntity.ok(course);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
//	POST
	@PostMapping("/post/topic/{topicId}/courses")
	public void addNewTopic(@RequestBody Course course, @PathVariable Integer topicId) {
		course.setTopic(new Topic(topicId, "",""));
		courseService.addCourse(course);
//		return courseService.getAllCourses();
	}
	
//	PUT
	@PutMapping("/update/topic/{topicId}/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Integer topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "",""));
		Course newCourse = courseService.updateCourse(course);
	    return ResponseEntity.ok(newCourse);
	}
	
//	DELETE
	@DeleteMapping("/delete/topic/{topicId}/courses/{id}")
	public void del(@PathVariable Integer id) {
		courseService.deleteCourse(id);
	}
	
}
