package com.umi.core;
 /*
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.oauth.OAuthService;
import com.google.appengine.api.oauth.OAuthServiceFactory;
import com.google.appengine.api.users.User;
 
import java.io.IOException;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ProtectedServlet extends HttpServlet {
     
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    User user = null;
    try {
        OAuthService oauth = OAuthServiceFactory.getOAuthService();
        user = oauth.getCurrentUser();
        resp.getWriter().println("Authenticated: " + user.getEmail());
    } catch (OAuthRequestException e) {
        resp.getWriter().println("Not authenticated: " + e.getMessage());
    }
    }
     
}
*/
public class ProtectedServlet extends AbstractAuthorizationCodeServlet {

	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws IOException {
	    // do stuff
	  }

	  @Override
	  protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
	    GenericUrl url = new GenericUrl(req.getRequestURL().toString());
	    url.setRawPath("/oauth2callback");
	    return url.build();
	  }

	  @Override
	  protected AuthorizationCodeFlow initializeFlow() throws IOException {
	    return new AuthorizationCodeFlow.Builder(BearerToken.authorizationHeaderAccessMethod(),
	        new NetHttpTransport(),
	        new JacksonFactory(),
	        new GenericUrl("https://server.example.com/token"),
	        new BasicAuthentication("s6BhdRkqt3", "7Fjfp0ZBr1KtDRbnfVdmIw"),
	        "s6BhdRkqt3",
	        "https://server.example.com/authorize").setCredentialStore(
	        new JdoCredentialStore(JDOHelper.getPersistenceManagerFactory("transactions-optional")))
	        .build();
	  }

	  @Override
	  protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
	    // return user ID
	  }
	}