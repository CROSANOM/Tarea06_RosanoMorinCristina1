package alquilerVehiculos.modelo;

import alquilerVehiculos.mvc.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.modelo.dao.Alquileres;
import alquilerVehiculos.mvc.modelo.dao.Clientes;
import alquilerVehiculos.mvc.modelo.dao.Vehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;


public class AlquilerVehiculos {
	// atributos
	private Clientes clientes;
	private Vehiculos vehiculos;
	private Alquileres alquileres;

	// constructor
	public AlquilerVehiculos() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();
	}

	// Metodos getters de atributos de AlquilerVehiculos
	// vehiculos-alquileres-clientes

	/**
	 * @return the clientes
	 */
	public Clientes getClientes() {
		return clientes;
	}

	/**
	 * @return the vehiculos
	 */
	public Vehiculos getVehiculos() {
		return vehiculos;
	}

	/**
	 * @return the alquileres
	 */
	public Alquileres getAlquileres() {
		return alquileres;
	}

	// Getters clientes, vehiculos, alquileres : return [ ] )

	public Cliente[] ObtenerCliente() {
		return clientes.getClientes();
	}

	public Vehiculo[] ObtenerVehiculos() {
		return vehiculos.getVehiculo();
	}

	public Alquiler[] obtenerAlquileres() {
		return alquileres.getAlquileres();
	}

	// metodos clientes ( anadir, borrar, buscar )

	public void anadirCliente(Cliente cliente) {
		clientes.anadirCliente(cliente);
	}

	public void borrarCliente(String dni) {
		clientes.borrarCliente(dni);
	}

	public Cliente buscarCliente(String dni) {
		return clientes.buscarCliente(dni);
	}

	//metodos de los Vehiculos
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
        vehiculos.anadirVehiculo(vehiculo, tipoVehiculo);
    }
	
	public void borrarVehiculo(String matricula) {
		vehiculos.borrarVehiculo(matricula);
	}

	public Vehiculo buscarVehiculo(String matricula) {
		return vehiculos.buscarVehiculo(matricula);
	}

	// metodos para los alquileres

	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		alquileres.abrirAlquiler(cliente, vehiculo);
	}

	public void cerrarAlquiler(Vehiculo vehiculo) {
		alquileres.cerrarAlquiler(vehiculo);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlquilerVehiculos [clientes=" + clientes + ", vehiculos=" + vehiculos + ", alquileres=" + alquileres
				+ "]";
	}
}
