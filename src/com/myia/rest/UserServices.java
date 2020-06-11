package com.myia.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.myia.entity.User;
import com.myia.service.AbstractDAO;



@Path(value = "/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserServices extends AbstractDAO {
	private Logger logger=Logger.getLogger(UserServices.class.getName());

	/**
	 * Creates a new user in the database by default any created user is a guest user
	 *  url : https://server_address/[ROOT-CONTEXT]/rest/user/add
	 * @param  username
	 *                    the unique name for the user
	 * @param  password
	 *                    the clair text password
	 * 										
	 * @return          returns the user created with full record info
	 */
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addUser(
	        @FormParam("username") String username,
	        @FormParam("password") String password) {
		logger.log(Level.INFO,"received : "+username+" :"+password);
		User user = null;
		if (username != null && password != null) {
			user =userResolver.findByAttribute("username", username);
			if(user==null) {
			user = new User(username, password);
			user.setIsdeleted(false);
			user.setLoggedIn(false);
			userResolver.save(user);
			}else {
				user = null;
				return Response.ok("USERNAME ALREADY IN USE").build();
			}
		}
		return Response.ok(user).build();
	}
	
	/**
	 *  url : https://server_address/[ROOT-CONTEXT]/rest/user/update
	* @param  username
	 *                    the unique name for the user
	 * @param  password
	 *                    the clair text password
	 * @return
	 */
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response update(
	        @FormParam("username") String username,
	        @FormParam("password") String password) {
		logger.log(Level.INFO,"received : "+username+" :"+password);
		User user = null;
		if (username != null && password != null) {
			user =userResolver.findByAttribute("username", username);
			if(user==null) {
				return Response.ok("USER NOT FOUND").build();
			}else {
				user.setUsername(username);
				user.setPassword(password);
				userResolver.save(user);

			}
		}
		return Response.ok(user).build();
	}
	
	
	/**
	 * Creates a new user in the database by default any created user is a guest user, admin will add it to appropriate role
	 *  url : https://server_address/[ROOT-CONTEXT]/rest/user/delete
	 * @param  username
	 *                    the unique name for the user
	 * @param  password
	 *                    the clair text password
	 * 										
	 * @return          returns the user created with full record info
	 */
	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response removeUser(@FormParam("username") String username) {
		String result = "";
		User   user   = null;
		if (username != null) {
			user = userResolver.findByAttribute("username", username);
			if (user == null) {
				result = "USER NOT FOUND";
			} else {
				userResolver.delete(user);
				result = "USER DELETED";
			}
		}
		
		return Response.status(200).entity(result).build();
	}
	
	/**
	 * Finds a user from his username
	 *  url : https://server_address/[ROOT-CONTEXT]/rest/user/find
	 * @param  username
	 *                    the username to find using equal match filter
	 * 										
	 * @return          the user
	 */
	@POST
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response findUser(@FormParam("username") String username) {
		String resultat = "NO entity found";
		try {
			if (username != null) {
				User result = userResolver.findByAttribute("username", username);
				resultat = jsonFromEntity(result);
			} else {
				resultat = "Username must be supplied for this request";
			}
		} catch (Exception ex) {
			resultat = ex.getMessage();
		}
		return Response.ok(resultat, MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * lists all users in database
	 *  url : https://server_address/[ROOT-CONTEXT]/rest/user/list
	 * @return
	 */
	@GET
	@Path("/list")
	public Response findAllUser() {
		List<User> list = userResolver.findAll(User.class);
		return Response.ok(jsonFromEntity(list), MediaType.APPLICATION_JSON).build();
	}
	
}

