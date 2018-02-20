package alquilerVehiculos.mvc.controlador;

import alquilerVehiculos.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;
import alquilerVehiculos.mvc.vista.IUTextual;

public class ControladorAlquilerVehiculos {

	// atributos
	private AlquilerVehiculos modelo;
	private IUTextual vista;

	// constructor
	public ControladorAlquilerVehiculos(AlquilerVehiculos modelo, IUTextual vista) {
		this.vista = vista;
		this.modelo = modelo;
		vista.setControlador(this);
	}

	// metodos de controlador

	public void comenzar() {
		vista.comenzar();
	}

	
	// metodos de cliente Cliente 
	public void anadirCliente(Cliente cliente) {
		modelo.anadirCliente(cliente);
	}

	public void borrarCliente(String dni) {
		modelo.borrarCliente(dni);
	}

	public Cliente buscarCliente(String dni) {
		return modelo.buscarCliente(dni);
	}

	public Cliente[] obtenerClientes() {
		return modelo.ObtenerCliente();
	}

	// metodos de turismos 
	public void anadirTurismo(Turismo turismo) {
		modelo.anadirTurismo(turismo);
	}

	public void borrarTurismo(String matricula) {
		modelo.borrarTurismo(matricula);
	}

	public Turismo buscarTurismo(String matricula) {
		return modelo.buscarTurismo(matricula);
	}

	public Turismo[] obtenerTurismo() {
		return modelo.ObtenerTurismos();
	}
	// metodo de alquier

	public void abrirAlquiler(Cliente cliente, Turismo turismo) {
		modelo.abrirAlquiler(cliente, turismo);
		
	}

	public void cerrarAlquiler(Turismo turismo) {
		modelo.cerrarAlquiler(turismo);
	}

	public Alquiler[] obtenerAlquiler() {
		return modelo.obtenerAlquileres();
	}

}
