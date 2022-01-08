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
    @Path("hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN) //le type de retour
	public Response hello() {
		return Response
				.status(200)
				.entity("hello :)")
				.build()
;	}

}
