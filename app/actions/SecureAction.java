package actions;
import play.mvc.Http;
import utils.UsersData;
public class SecureAction{	
	public String authorized(Http.Context ctx) {
		String url = ctx.request().path();
		System.out.println(url);
		String token =null;
		try{
	token =  ctx.request().cookie("authorization").value();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	 if(token==null){
		 token="not yet set";
	 }
	   if(UsersData.token.equals(token)){    
		return url;
	   }
	   else
		 return "/";
	}

}
