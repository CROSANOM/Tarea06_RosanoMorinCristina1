package alquilerVehiculos.aplicacion;

import alquilerVehiculos.mvc.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;
import alquilerVehiculos.mvc.vista.utilidades.Entrada;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// instanciar la clase AlquilerVehiculos
		
	AlquilerVehiculos miAlquiler = new AlquilerVehiculos();
	DireccionPostal nPostal= new DireccionPostal("Calle","Localidad","04007");
	
	Cliente cliente1=new Cliente ( "nombre", "75875453R", nPostal);
	System.out.println(cliente1.toString());
	
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
					DireccionPostal direccionPostalIntroducida1 = new DireccionPostal(callet1,
							 localidadt1,codigoPostalt1);

					System.out.println("AHORA VAMOS A VER LA DIRECCIONPOSTALINTRO"+ direccionPostalIntroducida1.toString());
					
					
					System.out.println("\n añadir cliente");
					System.out.println("--------------");
					System.out.print("Nombre: ");
					String nombre = Entrada.cadena();
					System.out.print("DNI: ");
					String dni = Entrada.cadena();

					// prueba añadir cliente
					try {
						nuevoCliente = new Cliente(nombre, dni, direccionPostalIntroducida1);
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
					miAlquiler.anadeTurismo(nuevoTurismo);
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
