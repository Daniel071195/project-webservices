/**
 * 
 */
package com.danni.projectwebservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.danni.projectwebservices.entity.Empleado;
/**
 * @author danni
 *
 */
public class EmpleadoService {
	
	/* Simulacion con una base de datos 
	 * Metodo que permite consultar empleado por su id
	 * @Param numeroEmpleado {@link String} numero del empleado
	 * @return {@link Empleado} empleado consultado.*/
	
	public Empleado consultarEmpleadoPorNumEmpleado(String numEmpleado) {
		List<Empleado> empleadosConsultados = this.consultarEmpleados();
		
		for (Empleado empleadoConsultado : empleadosConsultados) {
			if (empleadoConsultado.getNumEmpleado().equals(numEmpleado)) {
				return empleadoConsultado;
			}
		}
		return null;
		
	}
	
	/*Metodo que simula la consulta de un empleado
	 * @return  {@link Empleado} Empleado consultado */
	public Empleado consultarEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setNumEmpleado("2356");
		empleado.setNombre("Daniel");
		empleado.setApellidoPaterno("Castañeda");
		empleado.setApellidoMaterno("Galindo");
		empleado.setEdad(27);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		return empleado;
	}
    /*Obtener una lista JSON
     * Metodo que permite consultar la lista de empleados
     * @return  {@link List} lista consultada */
	public List<Empleado> consultarEmpleados(){
		List<Empleado> empleados = new ArrayList();
		
		Empleado empleado = new Empleado();
		empleado.setNumEmpleado("2356");
		empleado.setNombre("Daniel");
		empleado.setApellidoPaterno("Castañeda");
		empleado.setApellidoMaterno("Galindo");
		empleado.setEdad(27);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		Empleado empleadoNuevo = new Empleado();
		empleadoNuevo.setNumEmpleado("52566");
		empleadoNuevo.setNombre("Artur");
		empleadoNuevo.setApellidoPaterno("Garcia");
		empleadoNuevo.setApellidoMaterno("Cruz");
		empleadoNuevo.setEdad(21);
		empleadoNuevo.setFechaCreacion(LocalDateTime.now());
		
		empleados.add(empleado);
		empleados.add(empleadoNuevo);
		
		return empleados;
		
	}
}
