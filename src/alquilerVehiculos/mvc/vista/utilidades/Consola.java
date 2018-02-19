package alquilerVehiculos.mvc.vista.utilidades;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;
import alquilerVehiculos.mvc.vista.Opcion;

// Esta clase contiene toda la entrada y salida de datos de la aplicacion

// metodos staticos: mostrarMenu, MostrarCabecera,  leer cliente, turismos, matricula, Dni, 
public class Consola {
	
	// constructor 
	public Consola() {
		
	}
	
// mostrar Menu 
	public static void mostrarMenu() {
		mostrarCabecera("Alquiler");
		for (Opcion opcion: Opcion.values()) {
			System.out.println(opcion);
		}
	}
	
	// Cabeceras de los listados de las opciones.
	public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s%n", mensaje);
		System.out.println(String.format("%0" + mensaje.length() + "d%n", 0).replace("0", "-"));
	}
	

//	// Elegir Opción 
//	public static int elegirOpcion() {
//		int ordinalOpcion;
//		do {
//			System.out.print("\nElige una opcion: ");
//			ordinalOpcion = Entrada.entero();
//		} while (!Opcion.esOrdinalValido(ordinalOpcion));
//		return ordinalOpcion;
//	}
	// 	leerCliente 
	public static Cliente leerCliente() {
		Cliente cliente = null;
		System.out.print("Nombre: ");
		String nombre = Entrada.cadena();
		System.out.print("DNI: ");
		String dni = Entrada.cadena();
		System.out.print("Direccion: ");
		String direccion = Entrada.cadena();
		System.out.print("Localidad: ");
		String localidad = Entrada.cadena();
		System.out.print("CodigoPostal: ");
		String codigoPostal = Entrada.cadena();
		cliente = new Cliente(nombre, dni,  new DireccionPostal(direccion, localidad, codigoPostal));
		return cliente;
	}
	// leerDni
	public static String leerDni() {
		System.out.print("Introduce el DNI del cliente: ");
		String dniBorrar = Entrada.cadena();
		return dniBorrar;
	}
	// 
	public static Turismo leerTurismo(Cliente cliente) {
		Turismo nuevoTurismo = null;
		System.out.print("Matrcula: ");
		String matricula = Entrada.cadena();
		System.out.print("Marca: ");
		String marca = Entrada.cadena();
		System.out.print("Modelo: ");
		String modelo = Entrada.cadena();
		System.out.print("Cilindrada: ");
		int cilindrada = Entrada.entero();
		nuevoTurismo = new Turismo( matricula, marca, modelo,  cilindrada);
		return nuevoTurismo;
	}
	
	public static String leerMatricula() {
		System.out.print("Introduce la matricula del turismo: ");
		String matriculaBorrar = Entrada.cadena();
		return matriculaBorrar;
	}
	


//	public static int elegirTipoVehiculo() {
//		int ordinalTipoVehiculo;
//		do {
//			System.out.printf("Elige el tipo de trabajo: ( %s)", obtenerTiposTrabajo());
//			ordinalTipoTrabajo = Entrada.entero();
//		} while (!TipoTrabajo.esOrdinalValido(ordinalTipoTrabajo));
//		return ordinalTipoTrabajo;
//	}
//	
//	private static String obtenerTiposTrabajo() {
//		StringBuilder tiposTrabajos = new StringBuilder("");
//		for (TipoTrabajo tipoTrabajo: TipoTrabajo.values()) {
//			tiposTrabajos.append(tipoTrabajo.ordinal()).append(".- ").append(tipoTrabajo).append(" ");
//		}
//		return tiposTrabajos.toString();
//	}
//
//}

	
	
}
