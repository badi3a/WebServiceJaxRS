package ressources;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("greeting")
public class Hello {

	public Hello() {
		// TODO Auto-generated constructor stub
	}
    //@Path("hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN) //le type de retour
	public Response hello() {
		return Response
				.status(200)
				.entity("hello :)")
				.build();}
    
    @Path("hello/{fName}/{lName}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHelloTo(@PathParam(value="fName") String name,
    		@PathParam(value="lName") String lname) {
    	return Response.status(200).entity("hello"+name+" "+lname).build();
    }
    
    @Path("test")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHelloToQuery(@QueryParam(value="fName") String name) {
    	return Response.status(200).entity("hello"+name).build();
    }

}
