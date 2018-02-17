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

	// acceso metodos get turismos-alquileres-clientes

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

	// acceso a metodos clientes :anadir - borrar- getCliente

	public void anadirCliente(Cliente cliente) {
		clientes.anadirCliente(cliente);
	}

	public void borrarCliente(String dni) {
		clientes.borrarCliente(dni);
	}

	// se usa en proximas versiones
	public Cliente[] getCliente() {
		return clientes.getClientes();

	}

	public Cliente getCliente(String dni) {
		return getCliente(dni);

	}

	// acceso a metodos turismos: anadir-borrar-getTurismo

	public void anadirTurismo(Turismo turismo) {
		turismos.anadirTurismo(turismo);
	}

	public void borrarTurismo(String matricula) {
		turismos.borrarTurismo(matricula);
	}

	public Turismo getTurismo(String matricula) {
		return getTurismo(matricula);

	}

	// se usa en proximas versiones
	public Turismo[] getTurismo() {
		return turismos.getTurismo();

	}

	// acceso metodos de alquileres : abrir - cerrar

	public void abrirAlquiler(Cliente cliente, Turismo turismo) {
		alquileres.abrirAlquiler(cliente, turismo);

	}

	public void cerrarAlquiler(Cliente cliente, Turismo turismo) {
		alquileres.cerrarAlquiler(cliente, turismo);
	}

	public Alquiler[] getAlquiler() {
		// TODO Auto-generated method stub
		return alquileres.getAlquiler();
	}

}
