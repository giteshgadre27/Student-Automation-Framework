package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.Student;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	
	public static Response readAllStudents() {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
					
				.when().get(Routes.get_url);
		return response;
	}
	
	
	public static Response createNewStudent(Student payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(Routes.post_url);
		return response;
	}
	
	public static Response updateUser(int Id, Student payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.queryParam("Id", Id).body(payload)

				.when().put(Routes.update_url);
		return response;
	}
	
	public static Response readStudentById(int Id) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				              .queryParam("Id", Id)
					
				.when().get(Routes.getById_url);
		return response;
	}
	
	public static Response deleteStudentById(int Id) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				              .queryParam("Id", Id)
					
				.when().delete(Routes.delete_url);
		return response;
		
	}
	 
		
}
