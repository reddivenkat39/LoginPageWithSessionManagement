package controllers;

import play.mvc.Controller;
import play.mvc.Http.Cookie;
import play.mvc.Result;
import services.TokenGeneratorService;

public class SigninPageController extends Controller{
	/*
	 * The signin() method is to signin page
	 */
public Result signin(){
	Cookie ck = new Cookie("initialcookie","cookievalue", null, null, null, false, false);
	return ok(views.html.signin.render()).withCookies(ck);
}
/*
 * The validate page is to validate the user by username and password
 */
public Result validate(String username, String password){
	TokenGeneratorService tokengen = new TokenGeneratorService();
	String token = tokengen.usertoken(username, password);
	Cookie redirecturlcookie = request().cookie("redirecturl");
	String redirecturl =null;
	System.out.println(redirecturl);
	if(token.equals("default"))
	return redirect("/");
	if(redirecturlcookie!=null){
		 redirecturl = redirecturlcookie.value();
		 response().discardCookie("redirecturl");
		Cookie ck = new Cookie("authorization",token, null, null, null, false,false);
	return redirect(redirecturl).withCookies(ck);
	}
	else
	{
		Cookie ck = new Cookie("authorization",token, null, null, null, false,false);
		return ok(views.html.validated.render()).withCookies(ck);
	}
}

public Result signout(){
	response().discardCookie("authorization");
	return ok(views.html.signin.render());
}
}
