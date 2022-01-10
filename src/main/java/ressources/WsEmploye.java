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
		//employes.add(new Employe (123, "Ahemd","Ben Foulen"));
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
	//addEmploye XML & JSON
	@POST
	@Path("add")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response ajouterEmploye(Employe employe) {
		 if(employes.add(employe))
	 return Response.status(201).entity("Add Successful").build();
	 return Response.status(200).entity("Echec: Error").build();
	  
	}
	//deleteEmploye
	@DELETE
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteEmpl(@QueryParam(value="id")int cin){
		int index= getIndexByCin(cin);
		if (index!=-1) {
			employes.remove(index);
			return Response.status(200).entity("delete Successful").build();
		}else 
			return Response.status(200).entity("delete error").build();
			
    }
	//UpdateEmploye
	@PUT
	@Path("update")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateEmploye(Employe e) {
		int index= this.getIndexByCin(e.getCin());
		if (index!=-1) {
			employes.set(index, e);
			return Response.status(201).entity("update Ok").build();
			
		}
		 return Response.status(200).entity("delete error").build();
	
	}
	
	//searchEmploye
	public int getIndexByCin(int cin) {
		for(Employe emp: employes) {
			if (emp.getCin()==cin)
				return employes.indexOf(emp);
		}
		return -1;
	}
	

}
