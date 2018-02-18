package alquilerVehiculos.modelo;

import alquilerVehiculos.mvc.modelo.dao.Alquileres;
import alquilerVehiculos.mvc.modelo.dao.Clientes;
import alquilerVehiculos.mvc.modelo.dao.Turismos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;

public class AlquilerVehiculos {
	// atributos
	private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;

	// constructor
	public AlquilerVehiculos() {
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres = new Alquileres();
	}

	// Metodos getters de atributos de AlquilerVehiculos
	// turismos-alquileres-clientes

	/**
	 * @return the clientes
	 */
	public Clientes getClientes() {
		return clientes;
	}

	/**
	 * @return the turismos
	 */
	public Turismos getTurismos() {
		return turismos;
	}

	/**
	 * @return the alquileres
	 */
	public Alquileres getAlquileres() {
		return alquileres;
	}

	// Getters clientes, turismos, alquileres : return [ ] )

	public Cliente[] ObtenerCliente() {
		return clientes.getClientes();
	}

	public Turismo[] ObtenerTurismos() {
		return turismos.getTurismo();
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

	// metodos turismos
	public void anadirTurismo(Turismo turismo) {
		turismos.anadirTurismo(turismo);
	}

	public void borrarTurismo(String matricula) {
		turismos.borrarTurismo(matricula);
	}

	public Turismo buscarTurismo(String matricula) {
		return turismos.buscarTurismo(matricula);
	}

	// metodos para los alquileres

	public void abrirAlquiler(Cliente cliente, Turismo turismo) {
		alquileres.abrirAlquiler(cliente, turismo);
	}

	public void cerrarAlquiler(Turismo turismo) {
		alquileres.cerrarAlquiler(turismo);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlquilerVehiculos [clientes=" + clientes + ", turismos=" + turismos + ", alquileres=" + alquileres
				+ "]";
	}
}
