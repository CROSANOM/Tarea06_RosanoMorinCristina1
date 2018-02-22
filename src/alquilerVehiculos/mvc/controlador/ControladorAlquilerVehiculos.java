package alquilerVehiculos.mvc.controlador;

import alquilerVehiculos.modelo.AlquilerVehiculos;
import alquilerVehiculos.mvc.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
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

	// metodos Vehiculos
	
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
        modelo.anadirVehiculo(vehiculo, tipoVehiculo);
    }

	public void borrarVehiculo(String matricula) {
		modelo.borrarVehiculo(matricula);
	}

	public Vehiculo buscarVehiculo(String matricula) {
		return modelo.buscarVehiculo(matricula);
	}

	public Vehiculo[] obtenerVehiculo() {
		return modelo.ObtenerVehiculos();
	}
	// metodo de alquier

	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		modelo.abrirAlquiler(cliente, vehiculo);
		
	}

	public void cerrarAlquiler(Vehiculo vehiculo) {
		modelo.cerrarAlquiler(vehiculo);
	}

	public Alquiler[] obtenerAlquiler() {
		return modelo.obtenerAlquileres();
	}

}
