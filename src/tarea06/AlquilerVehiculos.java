package tarea05;

import java.util.Arrays;

/**
 * @author crosanom
 *
 */

// Punto19 Crear la clase AlquilerVehiculos con sus atributos y visibilidad
// adecuados

public class AlquilerVehiculos {

	private Turismo[] turismos; // Array de tipo Turismo
	private Cliente[] clientes; // Array de tipo Cliente
	private Alquiler[] alquileres; // Array de tipo Alquiler

	private final int MAX_TURISMO = 8; // indicar el tamaño del array quiere tener coches de reserva
	private final int MAX_CLIENTES = 6;
	private final int MAX_ALQUILERES = 6;

	// Punto20 constructor inicializa los atributos crea los array

	public AlquilerVehiculos() {

		clientes = new Cliente[MAX_CLIENTES];
		turismos = new Turismo[MAX_TURISMO];
		alquileres = new Alquiler[MAX_ALQUILERES];
	}

	// Punto21 Crea los métodos get para cada atributo
	/**
	 * @return the MAX_TURISMO
	 */
	public int getMAX_TURISMO() {
		return MAX_TURISMO;
	}

	/**
	 * @return the MAX_CLIENTES
	 */
	public int getMAX_CLIENTES() {
		return MAX_CLIENTES;
	}

	/**
	 * @return the mAX_ALQUILERES
	 */
	public int getMAX_ALQUILERES() {
		return MAX_ALQUILERES;
	}

	/**
	 * @return the turismo
	 */
	public Turismo[] getTurismo() {
		return turismos;
	}

	/**
	 * @return the clientes
	 */
	public Cliente[] getClientes() {
		return clientes;
	}

	/**
	 * @return the alquileres
	 */
	public Alquiler[] getAlquileres() {
		return alquileres;
	}

	// creo toString AlquierVehiculo para print y controlar la clase en el main

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlquilerVehiculos [turismos=" + Arrays.toString(turismos) + ", clientes=" + Arrays.toString(clientes)
				+ ", alquileres=" + Arrays.toString(alquileres) + ", MAX_TURISMO=" + MAX_TURISMO + ", MAX_CLIENTES="
				+ MAX_CLIENTES + ", MAX_ALQUILERES=" + MAX_ALQUILERES + "]";
	}
	/*
	 * Punto22 Crear el método getCliente (String DNI ) similar al método Cliente
	 * buscar de la tarea de Taller Mecanico // recuperar Cliente por su dni
	 */

	public Cliente getCliente(String dni) {
		int posicion = 0;
		boolean encontrado = false;

		while (posicion < clientes.length && !encontrado) {
			if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni))
				encontrado = true;
			else
				posicion++;
		}
		if (encontrado)
			return clientes[posicion]; // devuelve Cliente cliente
		else
			return null;
	}

	/*
	 * Punto23 Crear metodo añadirCliente que se le pasa por parametro un cliente
	 * que añada un cliente al array de clientes si cabe y si no existe ningún otro
	 * con el mismo DNI o lance una excepción en caso contrario.
	 */

	/**
	 * @param cliente
	 */
	public void anadeCliente(Cliente cliente) {

		int posicion = 0;
		boolean posicionEncontrada = false;

		while (posicion < clientes.length && !posicionEncontrada) { // mientras posicion sea menor que el array y que
			// distinta a la encontrada
			if (clientes[posicion] == null) // si posición esta vacia
				posicionEncontrada = true; // posicion pasa de false a encontrada

			/*
			 * si la posición en la que estoy tiene un dni y es igual al dni de mi cliente
			 * que quiero añadir
			 */
			else if (clientes[posicion].getDni().equals(cliente.getDni()))

				throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI"); // salta excepción con msm
			// cliente exite
			else
				posicion++; // sino paso a la posición siguiente
		}

		// Si habia hueco y no está repetido, se añade el cliente.
		if (posicionEncontrada)
			clientes[posicion] = cliente;
		else
			throw new ExcepcionAlquilerVehiculos("El array de clientes está lleno."); // sino lanzo una excepcion
	}

	/*
	 * Punto24 Crea un método delCliente que borre un cliente, dado su DNI (
	 * parametro) del array de clientes si este existe
	 */

	/**
	 * @param dni
	 */

	public void borrarCliente(String dni) {

		int posicion = 0;
		boolean posicionEncontrada = false;

		while (posicion < clientes.length && !posicionEncontrada) {

			if (clientes[posicion] == null) // Posicion vacia.
				posicion++; // No hay cliente, pasar siguiente.

			else {

				if (clientes[posicion].getDni().equals(dni)) {
					// Borro cliente y salgo del while.
					clientes[posicion] = null;
					posicionEncontrada = true;
					System.out.println("Eliminado el cliente con éxito");

				} else
					posicion++;
			}
		}

		if (!posicionEncontrada) {
			System.out.println("No existe el cliente a borrar.");
		}

	}

	/*
	 * Punto25 Crea un método getTurismo que se le pase la matrícula de un turismo y
	 * nos lo devuelva si este existe o null en caso contrario.
	 */

	/**
	 * @param matricula
	 * @return
	 */
	public Turismo getTurismo(String matricula) {
		int posicion = 0;
		boolean encontrado = false;

		while (posicion < turismos.length && !encontrado) {
			if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula))
				encontrado = true;
			else
				posicion++;
		}
		if (encontrado)
			return turismos[posicion]; // devuelve Turismo turismo
		else
			return null; //
	}

	/*
	 * Punto 26 Crear un método addTurismo que añada un turismo al array de turismos
	 * si cabe y no existe ningún otro con la misma matrícula o lance una excepción
	 * en caso contrario.
	 */

	/**
	 * @param turismos
	 */
	public void anadeTurismo(Turismo turismo) {

		int posicion = 0;
		boolean posicionEncontrada = false;

		while (posicion < turismos.length && !posicionEncontrada) { // mientras posicion sea menor que el array y que
			// distinta a la encontrada
			if (turismos[posicion] == null) // si posición esta vacia
				posicionEncontrada = true; // posición a encontrada

			/*
			 * si la posición en la que estoy tiene un turismo y es igual que la matricula
			 * que quiero añadir lanzo excepción
			 */
			else if (turismos[posicion].getMatricula().equals(turismo.getMatricula()))

				throw new ExcepcionAlquilerVehiculos("Ya existe un tursimo con esta matricula"); // salta excepción con
			// msm
			// cliente exite
			else
				posicion++; // sino paso a la posición siguiente
		}

		// Si habia hueco y no está repetido, se añade el turismo.
		if (posicionEncontrada)
			turismos[posicion] = turismo;
		else
			throw new ExcepcionAlquilerVehiculos("El array de turismo está lleno."); // sino lanzo una excepcion
	}

	/*
	 * Punto 27 Crea un método delTurismo que borre un turismo, dada su matrícula,
	 * del array de turismos si este existe
	 */

	/**
	 * @param matricula
	 */
	public void borrarTurismo(String matricula) {

		int posicion = 0;
		boolean posicionEncontrada = false;

		while (posicion < turismos.length && !posicionEncontrada) {

			if (turismos[posicion] == null) // Posición vacia.
				posicion++; // No hay turismo, pasar a siguiente posición.

			else {

				if (turismos[posicion].getMatricula().equals(matricula)) {

					if (turismos[posicion].isDisponibilidad()) {
						// Borro cliente y salgo del while.
						turismos[posicion] = null;
						posicionEncontrada = true;
						System.out.println("Eliminado el turismo con éxito");
					} else {
						throw new ExcepcionAlquilerVehiculos(
								"Este turismo está actualmente en uso, no se puede eliminar.");
					}

				} else
					posicion++;
			}
		}

		if (!posicionEncontrada) {
			System.out.println("No existe el turismo a borrar.");
		}

	}

	/*
	 * Punto 28 Crea un método openAlquiler que dado un cliente y un turismo cree un
	 * nuevo alquiler y lo añada al array de alquileres. Para ello se debe comprobar
	 * que el turismo esté disponible. Haz un commit.
	 */

	/**
	 * @param cliente
	 * @param turismo
	 */
	public void abrirAlquiler(Cliente cliente, Turismo turismo) {

		int posicion = 0;
		boolean posicionEncontrada = false;

		// Si el vehiculo esta disponible se busca hueco en array.

		// Recorrer array mientras t < y exitahuecolibres
		while (posicion < alquileres.length && !posicionEncontrada) {
			// Si la posicion esta vacia se puede asignar el alquiler.
			if (alquileres[posicion] == null)
				posicionEncontrada = true;// PosicionEncontrada
			else if (alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto");
			else
				turismo.setDisponibilidad(false);
			posicion++;
		}

		// Si no ha encontrado un hueco vacio.
		if (posicionEncontrada) {

			// se crea un nuevo alquiler new ( llama constructor )
			alquileres[posicion] = new Alquiler(cliente, turismo);
			System.out.println(" Se ha creado el alquiler correctamente");

		}

		else
			throw new ExcepcionAlquilerVehiculos("El vehiculo no esta disponible.");

	}

	/*
	 * Punto29 Crea un metodo closeAlquiler que cierre el alquiler dado un cliente y
	 * un turismo
	 */

	/**
	 * @param cliente
	 * @param turismo
	 */
	public void cerrarAlquiler(Cliente cliente, Turismo turismo) {

		int posicion = 0;
		boolean posicionEncontrada = false;

		// Buscar en el array posicion
		while (posicion < alquileres.length && !posicionEncontrada) {// abre while
			// comprobar si existe alquiler ( posicion array alquiler ! null )
			if (alquileres[posicion] != null &&
			// Comparar si alquiler existe ( dni buscado + matricula buscado=dni + matricula
			// array )
					(alquileres[posicion].getCliente().getDni().equals(cliente.getDni()) // dni cliente del alquiler =
							// dniClienteBuscar
							&& alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula()))) { // matricula

				posicionEncontrada = true; // encontrado Alquiler

			} else // Si no es el alquiler, se pasa posicion.

				posicion++;

		} // cierre while

		if (posicionEncontrada) {

			alquileres[posicion].cerrarAlquiler();

			System.out.println("Ha cerrado el aquiler correctamente");

		} else

			throw new ExcepcionAlquilerVehiculos("No se ha encontrado ningun alquiler abierto");

	}
}

// finClase