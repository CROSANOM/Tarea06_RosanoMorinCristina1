package tarea05;

import utilidades.Entrada;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// instanciar la clase AlquilerVehiculos
		AlquilerVehiculos miAlquiler = new AlquilerVehiculos();

		// 1º Creamos y añadimos clientes- turismo - alquiler //

		/*
		 * CLIENTE: creamos objetos de cliente(String nombre, String dni, String
		 * direccion, String localidad, String codigoPostal)
		 */
		System.out.println(" Objetos cliente: ");
		Cliente cliente1 = new Cliente("Manolo Santander", "75875453V", "calle popurri", "Tarifa­", "11380");
		Cliente cliente2 = new Cliente("Antonio Martin", "75875452V", "calle Manuel de Falla", "Cadiz", "04002");
		Cliente cliente3 = new Cliente("Luis Rivero", "75875458R", "calle Juana La Loca", "Chipiona", "04008");
		Cliente cliente4 = new Cliente("Paco Alba", "75875452R", "calle pasodoble", "Chipiona", "04008");
		// mostramos el cliente1 por pantalla con el metodoToString
		System.out.println("Mostramos por pantalla el cliente1 " + cliente1.toString());
		System.out.println("Mostramos por pantalla el cliente2 " + cliente2.toString());

		// Añadimos los clientes 1 -2 - 4
		miAlquiler.anadeCliente(cliente1);
		miAlquiler.anadeCliente(cliente2);
		miAlquiler.anadeCliente(cliente4);
		miAlquiler.anadeCliente(cliente3);

		/*
		 * TURISMO: creamos un turismo (String matricula, String marca, String modelo,
		 * int cilindrada)
		 */
		System.out.println(" Objetos de turismo ");
		Turismo turismo1 = new Turismo("4444BBB", "Citroen", "Picaso", 1900);
		Turismo turismo2 = new Turismo("2222BBB", "Renault", "Space", 1600);
		Turismo turismo3 = new Turismo("4479BBB", "Citroen", "Picaso", 1900);
		Turismo turismo4 = new Turismo("2278BBB", "Renault", "Space", 1600);
		Turismo turismo5 = new Turismo("2278HBB", "Renault", "Space", 1600);
		// mostramos ejemplo de objetos turismo por Pantalla con el metodoToString
		System.out.println("turismo1" + turismo1.toString());
		System.out.println("turismo2" + turismo2.toString());
		System.out.println("turismo3" + turismo3.toString());
		System.out.println("turismo4" + turismo2.toString());
		System.out.println("turismo5" + turismo3.toString());

		// añadimos los turismos 1-2-3-4
		miAlquiler.anadeTurismo(turismo1);
		miAlquiler.anadeTurismo(turismo2);
		miAlquiler.anadeTurismo(turismo3);
		miAlquiler.anadeTurismo(turismo4);
	

		// COMPROBAR LA EXISTENCIA DE CLIENTES Y TURISMO EN LA APLICACION
		System.out.println("La aplicacion tiene \n " + miAlquiler.toString());

		/*
		 * ALQUILER primero abrimos alquiler comprobar disponibilidad coche, despues
		 * cerramos alquiler comprobamos cambio disponibilidad coche
		 */

		// Abrirmos un alquiler usar metodo abrirAlquiler si ok lanza msm */
		miAlquiler.abrirAlquiler(cliente2, turismo2);
		// Para comprobar que ok todo imprimir pantalla el alquiler
		System.out.println("Imprime mi alquiler" + miAlquiler.toString());
		System.out.println("Ahora el coche cambio de estado, su disponibilidad es  " + turismo2.isDisponibilidad());

		// cerrar alquiler
		miAlquiler.cerrarAlquiler(cliente2, turismo2);
		// Para comprobar cambio disponibilidad coche
		System.out.println("Imprime mi alquiler" + miAlquiler.toString());
		System.out.println("Despues de cerrar alquiler turismo2 cambió de estado, su disponibilidad es  "
				+ turismo2.isDisponibilidad());

		// for para recorrer y recuperar cliente, turismo y alquiler print cliente ,
		// turismos, alquileres

		for (Cliente cliente : miAlquiler.getClientes()) // clase AlquilerVehiculos
			if (cliente != null)
				System.out.println(cliente);
		System.out.println("--------------");
		for (Turismo turismo : miAlquiler.getTurismo())// clase AlquilerVehiculos
			if (turismo != null)
				System.out.println(turismo);
		System.out.println("--------------");
		for (Alquiler alquiler : miAlquiler.getAlquileres())
			if (alquiler != null)
				System.out.println(alquiler);

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
			switch (opcion) {

			case 1: // Añadir cliente
				Cliente nuevoCliente = null;
				do {

					System.out.println("\nAñadir cliente");
					System.out.println("--------------");
					System.out.print("Nombre: ");
					String nombre = Entrada.cadena();
					System.out.print("DNI: ");
					String dni = Entrada.cadena();
					System.out.print("Direccion: ");
					String direccion = Entrada.cadena();
					System.out.print("Localidad: ");
					String localidad = Entrada.cadena();
					System.out.print("Codigo postal: ");
					String codigoPostal = Entrada.cadena();
					// prueba añadir cliente
					try {
						nuevoCliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);
					} catch (ExcepcionAlquilerVehiculos e) {// si error
						System.out.printf("ERROR: %s%n%n", e.getMessage());
						System.out.println("Vuelve a introducir los datos de forma correcta");
					}
				} while (nuevoCliente == null);
				try {
					miAlquiler.anadeCliente(nuevoCliente);
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
				for (Cliente cliente : miAlquiler.getClientes()) {
					if (cliente != null)
						System.out.println(cliente.toString());
				}
				System.out.println("");
				break;
			case 4: // añadir turismo
				Turismo nuevoTurismo = null;
				System.out.println("\nAñadir Turismo");
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
					miAlquiler.anadeTurismo(nuevoTurismo);
				} catch (ExcepcionAlquilerVehiculos e) {
					System.out.printf("ERROR: %s%n%n", e.getMessage());
				}
				System.out.println("Turismo " + nuevoTurismo.toString());
				break;
			case 5: // borrar turismo
				System.out.println("\nBorrar Turismo");
				System.out.println("---------------");
				System.out.print("\nIntroduce la matri­cula del vehiculo a borrar: ");
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
				System.out.print("\nIntroduce la matri­cula del vehi­culo: ");
				String matriculaBuscar = Entrada.cadena();
				Turismo turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
				System.out.println("\nIntroduce el dni");
				String dni = Entrada.cadena();
				Cliente cliente = miAlquiler.getCliente(dni);

				if (turismoBuscado == null)
					System.out.println("ERROR: No existe un vehi­culo con dicha matricula\n");
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
				System.out.print("\nIntroduce la matricula del vehi­culo: ");
				matriculaBuscar = Entrada.cadena();
				turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);

				if (turismoBuscado == null)
					System.out.println("ERROR: No existe un vehiculo con dicha matri­cula\n");
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
				for (Alquiler alquiler : miAlquiler.getAlquileres()) {
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
