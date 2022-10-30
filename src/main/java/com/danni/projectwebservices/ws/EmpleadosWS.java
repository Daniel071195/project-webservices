/**
 * 
 */
package com.danni.projectwebservices.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.danni.projectwebservices.entity.Empleado;
import com.danni.projectwebservices.service.EmpleadoService;

/**
 * @author danni
 * WS "se recomienda para identificar que es un web services"
 * WebServices generado con Jersey.
 * @Path Ayudara a que nombre accedemos al webService
 */
@Path("empleadosWS")
public class EmpleadosWS {
	
	/*instancia de clase eempleadoservice*/
	private EmpleadoService empleadoService = new EmpleadoService();
	
	/*GET indicara que tipo de peticion se hace*/
    @Path("test")
    @GET
	public String test() {
		return "Probando WebService con Jersey";
	}
    
    @GET
    @Path("consultarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    /* CONSUMIR WEBSERVICE DESDE OTRA APLICACION*/
    @Consumes(MediaType.APPLICATION_JSON)
    public Empleado consultarEmpleado() {
    	return this.empleadoService.consultarEmpleado();
    }
    /*Lista de empleado*/
    
    @GET
    @Path("consultarEmpleados")
    @Produces(MediaType.APPLICATION_JSON)
    /* CONSUMIR WEBSERVICE DESDE OTRA APLICACION*/
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Empleado> consultarEmpleados(){
    	return this.empleadoService.consultarEmpleados();
    }
         
    /*metodo que regresa un objeto de tipo empleado */ 
    @GET
    @Path("consultarEmpleadoPorNumEmpleado/{numEmp}") /*pasar el valor {numEmp}*/
    @Produces(MediaType.APPLICATION_JSON)
    /* CONSUMIR WEBSERVICE DESDE OTRA APLICACION*/
    @Consumes(MediaType.APPLICATION_JSON)
    
    /*@PathParam "" notacion que permite indicar al webService que mediante la url va a llegar un parametro
     * y ese parametro es que se va a setear desde la url o desde la parte donde se valla a obtener */
    
    public Response consultarEmpleadoPorNumEmpleado(@PathParam("numEmp") String numEmpleado) {
    	/*hacer la consulta*/
    	Empleado empleadoConsultado = this.empleadoService.consultarEmpleadoPorNumEmpleado(numEmpleado);
    	/*en caso de que no se obtenga el empleado encontrado*/
    	if(empleadoConsultado == null) {
    		/*Regreso un objeto Response "No se encontro el contenido"*/
    		return Response.noContent().build();
    	}
    	/*GenericEntity "Cunado se trata de entidades"*/
    	GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleadoConsultado, Empleado.class) ;
    	
    	/*si encuentra el empleado consultado "OK empleadoConsultado"*/
    	return Response.ok(empleadoGeneric).build();
    }
    
    
    /*metodo POST */ 
    @POST
    @Path("guardarEmpleado") 
    @Produces(MediaType.APPLICATION_JSON)
    /* CONSUMIR WEBSERVICE DESDE OTRA APLICACION*/
    @Consumes(MediaType.APPLICATION_JSON)
    
    /* Resivimos un objeto de tipo empleado */
    public Response guardarEmpleado(Empleado empleado) {
    	/*verificar si el empleado llega nulo*/
    	if (empleado == null) {
    		return Response.status(400)
    				.entity("No se ingreso informacion del empleado, favor de capturar sus datos").build();
    	}
    	/*caso "si no asigno el nombre" nombre == null.........  getNombre(boolean)*/
    	if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
    		return Response.status(400)
    				.entity("El nombre es requerido").build();
    	}
    	
    	/*regresar el empleado guardado*/
    	GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class) ;
    	
    	return Response.ok(empleadoGeneric).build();
    }
}      
    

