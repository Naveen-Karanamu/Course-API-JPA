## Spring REST API Documentation - Topics and Courses

This API provides functionalities for managing topics and their associated courses.

**Communication:**

- **Content-Type:** Application/JSON is used for both request and response bodies.
- **Spring Annotations:** The API leverages Spring annotations for controller definitions and dependency injection.
- **Error Responses:** Responses include an error message and status code in case of exceptions.

**1. Topics API**

**Endpoints:**

* **GET /get/topics**
    * Description: Retrieves a list of all topics.
    * Response: JSON array of `Topic` objects.
* **GET /get/topic/{id}**
    * Description: Gets a specific topic by its ID.
    * Path Parameter: `{id}` - The numeric ID of the topic to retrieve.
    * Response: JSON object representing the `Topic` or a Not Found status code if not found.
* **POST /post/topic**
    * Description: Creates a new topic.
    * Request Body: JSON object representing the new `Topic`.
    * Response: JSON array containing the list of topics after creation (including the newly created one).
* **PUT /update/topic/{id}**
    * Description: Updates an existing topic.
    * Path Parameter: `{id}` - The numeric ID of the topic to update.
    * Request Body: JSON object representing the updated `Topic`.
    * Response: JSON object representing the updated `Topic` or a Not Found status code if not found.
* **DELETE /delete/topic/{id}**
    * Description: Deletes a topic by its ID.
    * Path Parameter: `{id}` - The numeric ID of the topic to delete.
    * Response: No response body, but deletes the specified topic (returns void).

**2. Courses API**

**Endpoints (all require a topic ID in the path):**

* **GET /get/topics/{id}/courses**
    * Description: Retrieves all courses associated with a specific topic.
    * Path Parameter: `{id}` - The numeric ID of the topic to get courses for.
    * Response: JSON array of `Course` objects.
* **GET /get/topic/{topicId}/courses/{id}**
    * Description: Gets a specific course by its ID within a topic.
    * Path Parameters:
        * `{topicId}` - The numeric ID of the topic containing the course.
        * `{id}` - The numeric ID of the course to retrieve.
    * Response: JSON object representing the `Course` or a Not Found status code if not found.
* **POST /post/topic/{topicId}/courses**
    * Description: Creates a new course associated with a specific topic.
    * Path Parameter: `{topicId}` - The numeric ID of the topic for the new course.
    * Request Body: JSON object representing the new `Course`. The course object should include the topic ID in its request body.
    * Response: No response body, but creates the new course associated with the specified topic.
* **PUT /update/topic/{topicId}/courses/{id}**
    * Description: Updates an existing course within a topic.
    * Path Parameters:
        * `{topicId}` - The numeric ID of the topic containing the course.
        * `{id}` - The numeric ID of the course to update.
    * Request Body: JSON object representing the updated `Course`. The course object should include the topic ID in its request body.
    * Response: JSON object representing the updated `Course`.
* **DELETE /delete/topic/{topicId}/courses/{id}**
    * Description: Deletes a course by its ID within a topic.
    * Path Parameters:
        * `{topicId}` - The numeric ID of the topic containing the course.
        * `{id}` - The numeric ID of the course to delete.
    * Response: No response body, but deletes the specified course (returns void).

**Note:**

- The `Course` API endpoints require the corresponding topic to exist before creating or updating courses.
- Error responses might include details about exceptions encountered during processing.

