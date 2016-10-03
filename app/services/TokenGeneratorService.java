package services;
import models.users;
import play.libs.Json;
import utils.UsersData;

public class TokenGeneratorService {
	
public String usertoken(String username,String password){
	String token="default";
	UsersData userdata = new UsersData();
	users user = Json.fromJson(userdata.generateuserjson(), users.class);
	System.out.println(user.getName()+" "+user.getPassword());
	System.out.println(username+ " "+password);
	if(username.equals(user.getName())&&password.equals(user.getPassword())){
		System.out.println("reaching");
		token = username+password;
		UsersData.token=token;
		return token; 
	}
	return token;
}
}
