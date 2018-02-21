package alquilerVehiculos.aplicacion;

import alquilerVehiculos.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.controlador.ControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.vista.IUTextual;

// Accedo a las clases que controlan la aplicación incluida la consola no se instancian sus metodos Staticos
public class PrincipalAlquilerVehiculos {

	public static void main(String[] args) {
		AlquilerVehiculos modelo = new AlquilerVehiculos();
		IUTextual vista = new IUTextual();
		ControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(modelo, vista);

		controlador.comenzar();
	}

}
