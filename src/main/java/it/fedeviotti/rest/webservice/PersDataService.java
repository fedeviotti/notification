package it.fedeviotti.rest.webservice;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.Produces;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;

import it.fedeviotti.rest.pojo.User;
import it.fedeviotti.rest.pojo.UserPB;
import it.fedeviotti.rest.service.UsersDB;

@Path("/users")
public class PersDataService {

	// Restituzione lista delle persone in formato testo.
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<User> getPeopleBrowser() {
		UsersDB db = UsersDB.getInstance();
		return db.getAll();
	}

	// restituzione lista in formato XML/JSON per chiamate applicative.
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getPeople() {
		UsersDB db = UsersDB.getInstance();
		return db.getAll();
	}

	// Metodo di salvataggio di nuovi record a fronte di una chiamata POST
	@POST
	@Path("add")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String nuovaPersona(@FormParam("username") String username, @FormParam("accessToken") String accessToken,
			@Context HttpServletResponse servletResponse) throws IOException {
		User user = new User(username, accessToken, new Date(), 0);
		UsersDB db = UsersDB.getInstance();
		db.add(user);
		return "User " + username + " added";
	}

	// recupera le info del mio utente su pushbullet
	@GET
	@Path("myuser")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMyUser(@Context HttpServletResponse servletResponse) throws IOException {

		// FUNZIONA!! recupera le info user e le mostra a video
		return Client.create().resource("https://api.pushbullet.com/v2/users/me")
				.accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON)
				.header("Access-Token", "o.LCGcUVrNpgSKWNQ7MRrt6Ny1NGaKAtL9")
				.get(String.class);

	}

	// Metodo di salvataggio di nuovi record a fronte di una chiamata POST
	@POST
	@Path("notification/push")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String pushNotification(
			@FormParam("username") String username, 
			@Context HttpServletResponse servletResponse){

		UsersDB db = UsersDB.getInstance();
		User user = db.get(username);

		String token = user.getAccessToken();
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("type", "note");
		queryParams.add("title", "Titolo");
		queryParams.add("body", "Corpo del testo");
		queryParams.add("iden", "ujyx8OA2x6OsjAiVsKnSTs");

		try {
			return Client.create().resource("https://api.pushbullet.com/v2/pushes")
					.accept(MediaType.APPLICATION_JSON)
					.type(MediaType.APPLICATION_FORM_URLENCODED)
					.header("Access-Token", token)
					.post(String.class, queryParams);
		} catch (Exception e) {
			System.out.println("Errore :::" + e.getMessage());
			return "";
		}
		

	}
}
