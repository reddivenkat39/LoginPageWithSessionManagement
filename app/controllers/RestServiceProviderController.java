package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import actions.SecureAction;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.Context;
import play.mvc.Http.Cookie;
import play.mvc.Result;
import utils.UsersData;

public class RestServiceProviderController extends Controller{
/*
 * The first defense is to ckeck if the user is authenticated or not by checking the cookie
 * and the header
 */
	public Result usersdata(){
		Context ctx = Http.Context.current();
		SecureAction secureaction = new SecureAction();
		String url = secureaction.authorized(ctx);
		String redirectingurl = request().path();
		System.out.println(url+" "+redirectingurl);
		if(!url.equals("/")){
		UsersData user = new UsersData();
		JsonNode userjson =user.generateuserjson();
		Cookie ck = new Cookie("cookie","authenticated", null, null, null, false, true);
		return ok(userjson).withCookies(ck);
		}
		else{
			Cookie ck = new Cookie("redirecturl",redirectingurl,null,null,null,false,false);
			return redirect("/").withCookies(ck);
			
		}
	}
}
