package learnAPI.restAPI.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	/*
	 * List<Course> courses = new ArrayList<>( Arrays.asList( new Course(1,
	 * "Spring","Spring Description"), new Course(2, "Java","Java Description"), new
	 * Course(3, "Web","Web Description") ) );
	 */
	
	
//	GET
	public List<Course> getAllCourses(Integer topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		
		return courses;
	}
	
	public Optional<Course> getCourse(int id) {
		
		Optional<Course> course=courseRepository.findById(id);
		return course;
	}
	
//	POST
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
//	PUT
	public Course updateCourse(Course course) {
		
		Course updatedCourse= courseRepository.save(course);
		return updatedCourse;
	}
	
	
//DELETE
	public void deleteCourse(Integer id) {
		
		courseRepository.deleteById(id);
	}


}
