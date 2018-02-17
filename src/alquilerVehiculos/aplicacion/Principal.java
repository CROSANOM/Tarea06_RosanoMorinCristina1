package alquilerVehiculos.aplicacion;

import alquilerVehiculos.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;
import alquilerVehiculos.mvc.vista.utilidades.Entrada;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// instanciar la clase AlquilerVehiculos
		AlquilerVehiculos miAlquiler = new AlquilerVehiculos();
		DireccionPostal nuevaDirPostal = new DireccionPostal("La viña", "cadiz", "04007");
		Cliente cliente1= new Cliente ("Antonio Martin", "75875452V", nuevaDirPostal);
	
		/*System.out.println("\n Introducir datos para dirección Postal por teclado");
		System.out.println("--------------");
		System.out.print("Introduce la Calle");
		String calleN = Entrada.cadena();

		System.out.print("Introduce localidad: ");
		String localidadN = Entrada.cadena();

		System.out.print("Introduce codigoPostal: ");
		String codigoPostalN = Entrada.cadena();

		// instanciar un objeto direccionPostal con parametros leidos por teclado
		
		DireccionPostal direccionPostalIntroducida = new DireccionPostal(calleN, localidadN, codigoPostalN);
		System.out.println("Mostrar la direccionPostal Introducida por teclado" + direccionPostalIntroducida.toString());

		System.out.println("\n Introducir datos para un cliente");
		System.out.println("--------------");
		System.out.print("Nombre: ");
		String nombre = Entrada.cadena();
		System.out.print("DNI: ");
		String dni = Entrada.cadena();

		// Direcciones postales.
		DireccionPostal unaDireccionPostal1 = new DireccionPostal("calle popurri", "Chiclana", "11380");
		DireccionPostal unaDireccionPostal2 = new DireccionPostal("calle cuple", "cai", "11360");
		
		/* Clientes. 
		Cliente cliente1 = new Cliente("Manolo Santander", "75875453V", unaDireccionPostal1);
		Cliente cliente2 = new Cliente("Antonio Martin", "75875452V", unaDireccionPostal1);
		

		// Añadimos los clientes 1 -2 - 4
		miAlquiler.anadirCliente(cliente1);
		miAlquiler.anadirCliente(cliente2);
	
		System.out.println("INTRODUCIR LOS DATOS POR TECLADO PARA CREAR UNA DIRECCION");
		
		System.out.println("Introduce la calle");
		String calle = Entrada.cadena();
		System.out.println("Introduce la localidad");
		String localidad = Entrada.cadena();
		System.out.println("Introduce codigoPostal");
		String codigoPostal = Entrada.cadena();

		DireccionPostal unadireccionPostalT = new DireccionPostal(calle, localidad, codigoPostal);
		System.out.println("Mostrar la direccionPostal creada" + unadireccionPostalT.toString());

		System.out.println("INTRODUCIR LOS DATOS POR TECLADO PARA CREAR UN CLIENTE ");

		System.out.println("Introduce nombre");
		String nombreCliente5 = Entrada.cadena();
		System.out.println("Introduce dni");
		String dniCliente5 = Entrada.cadena();
		Cliente cliente5 = new Cliente(nombreCliente5, dniCliente5, unadireccionPostalT);
		
		System.out.println("INTRODUCIR LOS DATOS POR TECLADO PARA CREAR UN TURISMO ");*/

		// mostramos ejemplo de objetos turismo por Pantalla con el metodoToString
		
		/* public Turismo(String matricula, String marca, String modelo, int cilindrada
		
		System.out.println("Introduce matricula");
		String matriculaT  = Entrada.cadena();
		System.out.println("Introduce marca");
		String marcaT = Entrada.cadena();
		System.out.println("Introduce Modelo");
		String modeloT=Entrada.cadena();
		System.out.println("Introduce Cilindrada");
		int cilindradaT=Entrada.entero();
		
		Turismo turismoT=new Turismo (matriculaT,marcaT,modeloT,cilindradaT);
		
		System.out.println(turismoT.getMatricula() + "" + turismoT.getMarca() + turismoT.getModelo() + turismoT.getCilindrada());
		
		Cliente cliente6 = new Cliente(nombreCliente5, dniCliente5, unadireccionPostalT);
		
		
		System.out.println("Mostramos por pantalla el cliente1 " + cliente1.toString());
		System.out.println("Mostramos por pantalla el cliente2 " + cliente2.toString());
		System.out.println("Mostramos por pantalla el cliente5 " + cliente5.toString());*/

		/*
		 * TURISMO: creamos un turismo (String matricula, String marca, String modelo,
		 * int cilindrada)
		 
		System.out.println(" Objetos de turismo ");
		
		Turismo turismo1 = new Turismo("4444BBB", "Citroen", "Picaso", 1900);
		Turismo turismo2 = new Turismo("2222BBB", "Renault", "Space", 1600);*/
		

		/* mostramos ejemplo de objetos turismo por Pantalla con el metodoToString
		
		// public Turismo(String matricula, String marca, String modelo, int cilindrada) 
		
		
		System.out.println("turismo1" + turismo1.toString());
		System.out.println("turismoT" + turismoT.toString());*/
		
		

		/* aÃ±adimos los turismos 1-2-3
		miAlquiler.anadirTurismo(turismo1);
		miAlquiler.anadirTurismo(turismo2);
		miAlquiler.anadirTurismo(turismoT);

		// COMPROBAR LA EXISTENCIA DE CLIENTES Y TURISMO EN LA APLICACION
		System.out.println("La aplicacion tiene \n " + miAlquiler.toString());

		/*
		 * ALQUILER primero abrimos alquiler comprobar disponibilidad coche, despues
		 * cerramos alquiler comprobamos cambio disponibilidad coche
		 */

		/* Abrirmos un alquiler usar metodo abrirAlquiler si ok lanza msm 
		miAlquiler.abrirAlquiler(cliente2, turismo2);
		// Para comprobar que ok todo imprimir pantalla el alquiler
		System.out.println("Imprime mi alquiler" + miAlquiler.toString());
		System.out.println("Ahora el coche cambio de estado, su disponibilidad es  " + turismo2.getDisponible());*/

		/* cerrar alquiler
		miAlquiler.cerrarAlquiler(cliente2, turismo2);
		// Para comprobar cambio disponibilidad coche
		System.out.println("Imprime mi alquiler" + miAlquiler.toString());
		System.out.println("Despues de cerrar alquiler turismo2 cambiÃ³ de estado, su disponibilidad es  "
				+ turismo2.getDisponible());*/

		/*for para recorrer y recuperar cliente, turismo y alquiler print cliente ,
		// turismos, alquileres

		for (Cliente cliente : miAlquiler.getCliente()) // clase AlquilerVehiculos
			if (cliente != null)
				System.out.println(cliente);
		System.out.println("--------------");
		for (Turismo turismo : miAlquiler.getTurismo())// clase AlquilerVehiculos
			if (turismo != null)
				System.out.println(turismo);
		System.out.println("--------------");
		for (Alquiler alquiler : miAlquiler.getAlquiler())
			if (alquiler != null)
				System.out.println(alquiler);*/

		// do - while valida la entrada menu

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
			System.out.println("4.- Añadir Â­Turismo");
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
			switch (opcion) {

			case 1: // Añadir cliente
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
					DireccionPostal direccionPostalIntroducida1 = new DireccionPostal(callet1, localidadt1,
							codigoPostalt1);

			

					System.out.println("\n añadir cliente");
					System.out.println("--------------");
					System.out.print("Nombre: ");
					String nombre1 = Entrada.cadena();
					System.out.print("DNI: ");
					String dni1 = Entrada.cadena();

					// prueba añadir cliente
					try {
						nuevoCliente = new Cliente(nombre1, dni1, direccionPostalIntroducida1);
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
				break;
			case 2: // borrar Cliente
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
				break;

			case 3: // listar Cliente
				System.out.println("\nListado de clientes");
				System.out.println("-------------------");
				for (Cliente cliente : miAlquiler.getCliente()) {
					if (cliente != null)
						System.out.println(cliente.toString());
				}
				System.out.println("");
				break;
			case 4: // añadir turismo
				Turismo nuevoTurismo = null;
				System.out.println("\nAÃ±adir Turismo");
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
				break;
			case 5: // borrar turismo
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
				break;

			case 6: // listar turismo
				System.out.println("\nListado de Turismo");
				System.out.println("--------------------");
				for (Turismo turismo : miAlquiler.getTurismo()) {
					if (turismo != null)
						System.out.println(turismo);

				}
				System.out.println("");
				break;

			case 7:// abrir alquiler
				System.out.println("\nAbrir Alquiler");
				System.out.println("-------------");
				System.out.print("\nIntroduce la matriÂ­cula del vehiÂ­culo: ");
				String matriculaBuscar = Entrada.cadena();
				Turismo turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
				System.out.println("\nIntroduce el dni");
				String dni1 = Entrada.cadena();
				Cliente cliente = miAlquiler.getCliente(dni1);

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

				break;

			case 8:
				System.out.println("\n Cerrar Alquiler");
				System.out.println("--------------");
				System.out.print("\nIntroduce la matricula del vehiÂ­culo: ");
				matriculaBuscar = Entrada.cadena();
				turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);

				if (turismoBuscado == null)
					System.out.println("ERROR: No existe un vehiculo con dicha matriÂ­cula\n");
				else {
					try {
						miAlquiler.cerrarAlquiler(cliente1, turismoBuscado);
						System.out.println("Alquiler cerrado satisfactoriamente");
						System.out.println("Alquiler cerrado =" + miAlquiler.getAlquileres());
					} catch (ExcepcionAlquilerVehiculos e) {
						System.out.printf("ERROR: %s%n%n", e.getMessage());
					}
				}
				break;

			case 9: // listado alquiler
				System.out.println("\nListado de Alquileres");
				System.out.println("---------------------");
				for (Alquiler alquiler : miAlquiler.getAlquiler()) {
					if (alquiler != null)
						System.out.println("Estos son los alquileres:\n" + alquiler + "ver los alquileres"
								+ miAlquiler.toString());
				}

				break;
			default:
				break;
			}// fin swich
		} while (opcion != 0);

	}

}
