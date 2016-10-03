package utils;

import com.fasterxml.jackson.databind.JsonNode;

import models.users;
import play.libs.Json;
//This is dummy data for the model users
public class UsersData {
	public static String token="default";
	public JsonNode generateuserjson(){
		users user = new users("venkat","male",23,"mangina");
		JsonNode userjson = Json.toJson(user);
		return userjson;
	}
	
}
