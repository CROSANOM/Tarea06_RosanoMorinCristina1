package alquilerVehiculos.mvc.vista;

import alquilerVehiculos.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.controlador.ControladorAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;
import alquilerVehiculos.mvc.vista.utilidades.Consola;
import alquilerVehiculos.mvc.vista.utilidades.Entrada;

public class IUTextual {

	// atributo
	private ControladorAlquilerVehiculos controlador;
	private Opcion vista;

	// constructor
	public IUTextual() {
		Opcion.setVista(this);
	}

	// SetControlado(Controlador )

	public void setControlador(ControladorAlquilerVehiculos controlador) {
		this.controlador=controlador;

	}

	// Metodo de comenzar ( getOpcionSegunOrdinal ) metodo de Option

	public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	// metodo Salir
	public void salir() {
		System.out.println("Hasta Pronto, gracias");
	}

	// metodo de alquileres

	// ListarAquileres
	public static void listarAlquileres(AlquilerVehiculos miAlquiler) {
		System.out.println("\nListado de Alquileres");
		System.out.println("---------------------");
		for (Alquiler alquiler : miAlquiler.obtenerAlquileres()) {
			if (alquiler != null)
				System.out.println(
						"Estos son los alquileres:\n" + alquiler + "ver los alquileres" + miAlquiler.toString());
		}
	}



	// Metodos de turismo

	// ListarTurismos
	public void listarTurismos() {
		Consola.mostrarCabecera("Listar Turismos");
		for (Turismo turismo : controlador.obtenerTurismo()) {
			if (turismo != null)
				System.out.println(turismo);
		}
		System.out.println("");
	}

	// buscarTurismo
	public void buscarTurismo() {
		Consola.mostrarCabecera("Buscar Turismo");
		String matricula = Consola.leerMatricula();
		Turismo turismoBuscado = controlador.buscarTurismo(matricula);
		String mensaje = (turismoBuscado != null) ? turismoBuscado.toString() : "El vehículo no existe";
		System.out.printf("%s%n%n", mensaje);
	}

	// borrarTurismo
	public void borrarTurismo() {
		Consola.mostrarCabecera("Borrar Turismo");
		String matricula = Consola.leerMatricula();
		try {
			controlador.borrarTurismo(matricula);
			System.out.println("Turismo borrado satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}
			
		// anadirTurismo
		public void anadirTurismo() {
			Consola.mostrarCabecera("Anadir Turismo");
			try {
				Turismo turismo = Consola.leerTurismo();
				controlador.anadirTurismo(turismo);
				System.out.println("Turismo anadido satisfactoriamente\n");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}

	// metodos de Clientes

	// listar
	public void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");
		for (Cliente cliente : controlador.obtenerClientes()) {
			if (cliente != null)
				System.out.println(cliente);
		}
		System.out.println("");
	}

	// buscarCliente
	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		String dni = Consola.leerDni();
		Cliente cliente = controlador.buscarCliente(dni);
		String mensaje = (cliente != null) ? cliente.toString() : "El cliente no existe";
		System.out.printf("%s%n%n", mensaje);
	}

	// borrar
	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		String dni = Consola.leerDni();
		try {
			controlador.borrarCliente(dni);
			System.out.println("Cliente borrado satisfactoriamente\n");
		} catch (Exception e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	// anadirCliente
	public void anadirCliente() {
		Consola.mostrarCabecera("Anadir cliente");
		try {
			Cliente cliente = Consola.leerCliente();
			controlador.anadirCliente(cliente);
			System.out.println("Cliente anadido satisfactoriamente\n");
		} catch (ExcepcionAlquilerVehiculos e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}

	// metodos de alquiler ( Consola.mostrarCabecera (String) | Consola.leerdni(dni)
	// | Consola.leerMatricula )

	// AbriAlquiler
	public void abrirAlquiler() {

		Consola.mostrarCabecera("Abrir Alquiler");
		String matricula = Consola.leerMatricula();
		String dni = Consola.leerDni();
		Turismo turismo = controlador.buscarTurismo(matricula);
		Cliente cliente = controlador.buscarCliente(dni);
		if (turismo == null)
			System.out.println("No existe un turismo con esa matr�cula" + "\n");
		else {
			try {
				controlador.abrirAlquiler(cliente, turismo);
				System.out.println("Alquier Abierto Satisfactoriamente");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}

	}
// cerrarAlquiler
	public void cerrarAlquiler() {
		Consola.mostrarCabecera("Cerrar Alquiler");
		String matricula=Consola.leerMatricula();
		Turismo turismo=controlador.buscarTurismo(matricula);
		if (turismo == null)
			System.out.println("ERROR: No existe un vehiculo con dicha matri­cula\n");
		else {
			try {
				controlador.cerrarAlquiler(turismo);
				System.out.println("Alquiler cerrado satisfactoriamente");
			} catch (ExcepcionAlquilerVehiculos e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}

// 	ListarAlquiler
	public void listarAlquileres() {
		Consola.mostrarCabecera("Listar Alquiler");
		for (Alquiler alquiler : controlador.obtenerAlquiler()) {
			if (alquiler != null)
				System.out.println(alquiler);
		}
		System.out.println("");
	}
		
		
	}


