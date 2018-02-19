package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;
import alquilerVehiculos.mvc.vista.utilidades.Entrada;

public class IUTextual {

	/**
		 * @param args
		 */
		public static void main(String[] args) {
		
			// Cuando haya interfaz habrá que tener un atributo del tipo de interfaz.
			// IControladorAlquilerVehiculos controlador;
			
			// Esta clase dejara de ser la main.
			// Esta clase representa la vista de la aplicacion.
			// Cuando tengas interface, sera un objeto del interface. Mientras será la clase directamente.
			AlquilerVehiculos alquilerVehiculosFuturoControlador = new AlquilerVehiculos();
	
			// Esto será un futuro metodo del interfaz para setear el controlador.
			AlquilerVehiculos controlador = alquilerVehiculosFuturoControlador;
			
			
			// Se utilizara el metodo del interfaz para lanzar el menu.
			//
				int opcion;
				do {
	
					// MENU
					System.out.println("MENU DE LA APLICACION:");
					System.out.println("/n");
					System.out.println("Alquiler Vehiculos");
					System.out.println("\n---------------");
					System.out.println("1.- Añadir cliente");
					System.out.println("2.- Borrar cliente");
					System.out.println("3.- Listar clientes");
					System.out.println("4.- Añadir ­Turismo");
					System.out.println("5.- Borrar Turismo");
					System.out.println("6.- Listar Turismo");
					System.out.println("7.- Abrir un Alquiler");
					System.out.println("8.- Cerrar alquiler");
					System.out.println("9.- Listar alquiler");
					System.out.println("0.- Salir");
					do {
						System.out.print("\nElige una opción (1-9) para salir pulsar 0: ");
						opcion = Entrada.entero();
	
					} while (opcion < 0 || opcion > 9); // entra en bucle
					
					// OPCIONES DE MENU.
					switch (opcion) {
	
					case 1: // Añadir cliente
						anadirCliente(alquilerVehiculosFuturoControlador);
						break;
					case 2: // borrar Cliente
						borrarCliente(alquilerVehiculosFuturoControlador);
						break;
	
					case 3: // listar Cliente
						listarCliente(alquilerVehiculosFuturoControlador);
						break;
					case 4: // añadir turismo
						anadirTurismo(alquilerVehiculosFuturoControlador);
						break;
					case 5: // borrar turismo
						borrarTurismo(alquilerVehiculosFuturoControlador);
						break;
	
					case 6: // listar turismo
						listarTurismo(alquilerVehiculosFuturoControlador);
						break;
	
					case 7:// abrir alquiler
						abrirAlquiler(alquilerVehiculosFuturoControlador);
	
						break;
	
					case 8:
						cerrarAlquiler(alquilerVehiculosFuturoControlador);
						break;
						
					case 9: // listado alquiler
						listarAlquileres(alquilerVehiculosFuturoControlador);
	
						break;
					default:
						break;
					}// fin swich
				} while (opcion != 0);
	
	
		}

	/**
	 * @param miAlquiler
	 */
	public static void listarAlquileres(AlquilerVehiculos miAlquiler) {
		System.out.println("\nListado de Alquileres");
		System.out.println("---------------------");
		for (Alquiler alquiler : miAlquiler.obtenerAlquileres()) {
			if (alquiler != null)
				System.out.println("Estos son los alquileres:\n" + alquiler + "ver los alquileres"
						+ miAlquiler.toString());
		}
	}

	/**
	 * @param miAlquiler
	 */
	public static void cerrarAlquiler(AlquilerVehiculos miAlquiler) {
		System.out.println("\n Cerrar Alquiler");
		System.out.println("--------------");
		System.out.print("\nIntroduce la matricula del vehiÂ­culo: ");
		String matriculaBuscar = Entrada.cadena();
		Turismo turismoBuscado = miAlquiler.buscarTurismo(matriculaBuscar);

		if (turismoBuscado == null)
			System.out.println("ERROR: No existe un vehiculo con dicha matriÂ­cula\n");
		else {
			try {
				miAlquiler.cerrarAlquiler(turismoBuscado);
				System.out.println("Alquiler cerrado satisfactoriamente");
				System.out.println("Alquiler cerrado =" + miAlquiler.getAlquileres());
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}

	/**
	 * @param miAlquiler
	 */
	public static void abrirAlquiler(AlquilerVehiculos miAlquiler) {
		System.out.println("\nAbrir Alquiler");
		System.out.println("-------------");
		System.out.print("\nIntroduce la matriÂ­cula del vehiÂ­culo: ");
		String matriculaBuscar = Entrada.cadena();
		Turismo turismoBuscado = miAlquiler.buscarTurismo(matriculaBuscar);
		System.out.println("\nIntroduce el dni");
		String dniT2 = Entrada.cadena();
		Cliente cliente = miAlquiler.buscarCliente(dniT2);

		if (turismoBuscado == null)
			System.out.println("ERROR: No existe un vehiÂ­culo con dicha matricula\n");
		else {
			try {
				miAlquiler.abrirAlquiler(cliente, turismoBuscado);
				System.out.println("Alquiler abierto satisfactoriamente\n");

			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}

	/**
	 * @param miAlquiler
	 */
	public static void listarTurismo(AlquilerVehiculos miAlquiler) {
		System.out.println("\nListado de Turismo");
		System.out.println("--------------------");
		for (Turismo turismo : miAlquiler.ObtenerTurismos()) {
			if (turismo != null)
				System.out.println(turismo);

		}
		System.out.println("");
	}

	/**
	 * @param miAlquiler
	 */
	public static void borrarTurismo(AlquilerVehiculos miAlquiler) {
		System.out.println("\nBorrar Turismo");
		System.out.println("---------------");
		System.out.print("\nIntroduce la matriÂ­cula del vehiculo a borrar: ");
		String matriculaBorrar = Entrada.cadena();
		try {
			miAlquiler.borrarTurismo(matriculaBorrar);
			System.out.println("Turismo borrado satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	/**
	 * @param miAlquiler
	 */
	public static void borrarCliente(AlquilerVehiculos miAlquiler) {
		System.out.println("\nBorrar cliente");
		System.out.println("--------------");
		System.out.print("\nIntroduce el DNI del cliente a borrar: ");
		String dniBorrar = Entrada.cadena();
		try {
			miAlquiler.borrarCliente(dniBorrar);
			System.out.println("Cliente borrado satisfactoriamente\n");
		} catch (Exception e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	/**
	 * @param miAlquiler
	 */
	public static void anadirCliente(AlquilerVehiculos miAlquiler) {
		Cliente nuevoCliente = null;
		do {

			System.out.println("\n añadir DireccionPostal");
			System.out.println("--------------");
			System.out.print("Calle");
			String callet1 = Entrada.cadena();
			System.out.print("Localidad: ");
			String localidadt1 = Entrada.cadena();
			System.out.print("codigoPostal: ");
			String codigoPostalt1 = Entrada.cadena();

			// instanciar un objeto direccionPostal con parametros leidos por teclado
			DireccionPostal direccionPoT = new DireccionPostal(callet1, localidadt1,
					codigoPostalt1);

			System.out.println("\n añadir cliente");
			System.out.println("--------------");
			System.out.print("Nombre: ");
			String nombreT = Entrada.cadena();
			System.out.print("DNI: ");
			String dniT = Entrada.cadena();

			// prueba añadir cliente
			try {
				nuevoCliente = new Cliente(nombreT, dniT, direccionPoT);
			} catch (ExcepcionAlquilerVehiculos e) {// si error
				System.out.printf("ERROR: %s%n%n", e.getMessage());
				System.out.println("Vuelve a introducir los datos de forma correcta");
			}
		} while (nuevoCliente == null);
		try {
			miAlquiler.anadirCliente(nuevoCliente);
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}

		System.out.println("Cliente " + nuevoCliente.toString());
	}

	/**
	 * @param miAlquiler
	 */
	public static void anadirTurismo(AlquilerVehiculos miAlquiler) {
		Turismo nuevoTurismo = null;
		System.out.println("\n añadir Turismo");
		System.out.println("---------------");
		System.out.println("Matricula: ");
		String matricula = Entrada.cadena();
		System.out.print("Marca: ");
		String marca = Entrada.cadena();
		System.out.print("Modelo: ");
		String modelo = Entrada.cadena();
		System.out.print("Cilindrada: ");
		int cilindrada = Entrada.entero();
		try {
			nuevoTurismo = new Turismo(matricula, marca, modelo, cilindrada);
			miAlquiler.anadirTurismo(nuevoTurismo);
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
		System.out.println("Turismo " + nuevoTurismo.toString());
	}

	/**
	 * @param miAlquiler
	 */
	public static void listarCliente(AlquilerVehiculos miAlquiler) {
		System.out.println("\nListado de clientes");
		System.out.println("-------------------");
		for (Cliente cliente : miAlquiler.ObtenerCliente()) {
			if (cliente != null)
				System.out.println(cliente.toString());
		}
		System.out.println("");
	}

	
	// Borrar luego
	public void salir() {
		// TODO Auto-generated method stub
		
	}

	public void borrar() {
		// TODO Auto-generated method stub
		
	}

	public void buscar() {
		// TODO Auto-generated method stub
		
	}

	public void listarTurismo() {
		// TODO Auto-generated method stub
		
	}

	
}
