package api.test;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.Student;

import api.utilities.ExtentReportManager;
import io.restassured.response.Response;

public class StudentTestCase {

	// GET ALL STUDENT

	@Test(priority = 1)
	void testGetAllStudents() {
		System.out.println(" GET ALL STUDENT");
		Response response = UserEndPoints.readAllStudents();
		response.then().statusCode(200).log().status();

		// Assertions assertEquals(response.getStatusCode(), 200);

		ExtentReportManager.logResponseDetails(response.getStatusCode(), response.getHeaders().asList(), null);

	}

	// ADD NEW STUDENT
	Faker faker = new Faker();
	Student userPayload = new Student();

	@BeforeClass
	public void setupData() {

		userPayload.setName(faker.name().fullName());
		userPayload.setAddress(faker.address().fullAddress());
	}

	@Test(priority = 2)
	void createNewStudent() {
		System.out.println("  ADD NEW STUDENT");
		Response response = UserEndPoints.createNewStudent(userPayload);
		response.then().statusCode(201).log().all();

		ExtentReportManager.logResponseDetails(response.getStatusCode(), response.getHeaders().asList(),
				response.getBody().asString());

	}

	public static int generateRandomId() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	// UPDATE EXISTING STUDENT
	@Test(priority = 3)
	void testUpdateStudent() {
		System.out.println("UPDATE EXISTING STUDENT");
		int randomId = generateRandomId();

		userPayload.setName(faker.name().fullName());
		userPayload.setAddress(faker.address().fullAddress());

		Response responseAfterUpdate = UserEndPoints.updateUser(randomId, userPayload);
		responseAfterUpdate.then().statusCode(200).log().all();
		ExtentReportManager.logResponseDetails(responseAfterUpdate.getStatusCode(),
				responseAfterUpdate.getHeaders().asList(), responseAfterUpdate.getBody().asString());

	}

	// GET EXISTING STUDENT
	@Test(priority = 4)
	void testGetStudentById() {
		System.out.println(" GET EXISTING STUDENT");
		int randomId = generateRandomId();
		// System.out.println(randomId);

		Response responseAfterUpdate = UserEndPoints.readStudentById(randomId);
		responseAfterUpdate.then().statusCode(200).log().all();

		ExtentReportManager.logResponseDetails(responseAfterUpdate.getStatusCode(),
				responseAfterUpdate.getHeaders().asList(), responseAfterUpdate.getBody().asString());

	}

	// DELETE EXISTING STUDENT
	@Test(priority = 5)
	void testDeleteStudentById() {
		System.out.println(" DELETE EXISTING STUDENT");
		int randomId = generateRandomId();
		// System.out.println(randomId);

		Response responseAfterUpdate = UserEndPoints.deleteStudentById(randomId);
		responseAfterUpdate.then().statusCode(204).log().all();

		ExtentReportManager.logResponseDetails(responseAfterUpdate.getStatusCode(),
				responseAfterUpdate.getHeaders().asList(), responseAfterUpdate.getBody().asString());

	}
	
	@Test(priority = 6)
	void createNewStudentWithMaximumData() {
		System.out.println("  ADD NEW STUDENT");
		Student userPayload = new Student();
		userPayload.setName("sAetITshPeSUYzawrmTzerXxGPLWcOJTQPtWuAgcYzdlOjIPRMvTsXdBMcWkgOyYHRRgwTOlbtrnZAShOjrUzLHzFdKEORooeKiHFTTilBCQuj");
		userPayload.setAddress("sAetITshPeSUYzawrmTzerXxGPLWcOJTQPtWuAgcYzdlOjIPRMvTsXdBMcWkgOyYHRRgwTOlbtrnZAShOjrUzLHzFdKEORooeKiHFTTilBCQuj");
		Response response = UserEndPoints.createNewStudent(userPayload);
		response.then().statusCode(200).log().all();

		// Assertions //assertEquals(response.getStatusCode(), 200); //cc
		/*
		 * assertNotNull(response.getBody().jsonPath().get("id")); //
		 * assertEquals(response.getBody().jsonPath().getString("username"), //
		 * userPayload.getUsername());
		 */

		ExtentReportManager.logResponseDetails(response.getStatusCode(), response.getHeaders().asList(),
				response.getBody().asString());

	}

	
	
	
	
}
