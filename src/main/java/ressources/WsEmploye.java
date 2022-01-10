package ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Employe;
@Path("employe")
public class WsEmploye {

	public static  List<Employe> employes=new ArrayList<Employe>();
	
	
	public WsEmploye() {
		// TODO Auto-generated constructor stub
		employes.add(new Employe (123, "Ahemd","Ben Foulen"));
	}
	
	//getEmploye XML & JSON
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_XML)
	public  Response displayEmployeesList() {
		if(employes.size()!=0) {
			GenericEntity data = new GenericEntity<List<Employe>>(employes){};
			return Response.status(200).entity(data).build();}
		else
			return Response.status(200).entity("liste Vide").build();
					
	}
	//addEmploye
	
	//deleteEmploye
	
	//UpdateEmploye
	
	
	//searchEmploye

}
