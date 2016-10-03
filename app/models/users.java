package models;

public class users {
public String name;
public String gender;
public int age;
public String token;
public String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public users(){
	
}
public users(String name, String gender, int age,String password){
	this.name = name;
	this.gender = gender;
	this.age = age;
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}


}
