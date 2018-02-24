package alquilerVehiculos.mvc.controlador;

import alquilerVehiculos.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.vista.IUTextual;

public class ControladorAlquilerVehiculos {

	// atributos
	private AlquilerVehiculos modelo;
	private IUTextual vista;

	// constructor
	/**
	 * @param modelo
	 * @param vista
	 */
	
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
	/**
	 * @param cliente
	 */
	public void anadirCliente(Cliente cliente) {
		modelo.anadirCliente(cliente);
	}

	/**
	 * @param dni
	 */
	public void borrarCliente(String dni) {
		modelo.borrarCliente(dni);
	}

	/**
	 * @param dni
	 * @return
	 */
	public Cliente buscarCliente(String dni) {
		return modelo.buscarCliente(dni);
	}

	/**
	 * @return
	 */
	public Cliente[] obtenerClientes() {
		return modelo.ObtenerCliente();
	}

	// metodos Vehiculos
	
	/**
	 * @param vehiculo
	 * @param tipoVehiculo
	 */
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
        modelo.anadirVehiculo(vehiculo, tipoVehiculo);
    }

	/**
	 * @param matricula
	 */
	public void borrarVehiculo(String matricula) {
		modelo.borrarVehiculo(matricula);
	}

	/**
	 * @param matricula
	 * @return
	 */
	public Vehiculo buscarVehiculo(String matricula) {
		return modelo.buscarVehiculo(matricula);
	}

	/**
	 * @return
	 */
	public Vehiculo[] obtenerVehiculo() {
		return modelo.ObtenerVehiculos();
	}
	// metodo de alquier

	/**
	 * @param cliente
	 * @param vehiculo
	 */
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.abrirAlquiler(cliente, vehiculo);
		
	}

	/**
	 * @param vehiculo
	 */
	public void cerrarAlquiler(Vehiculo vehiculo) {
		modelo.cerrarAlquiler(vehiculo);
	}

	/**
	 * @return
	 */
	public Alquiler[] obtenerAlquiler() {
		return modelo.obtenerAlquileres();
	}
	
	
	public void anadirDatosPrueba() {
		modelo.anadirDatosPrueba();
		
	}

}
