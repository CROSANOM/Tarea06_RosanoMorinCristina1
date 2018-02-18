package alquilerVehiculos.mvc.modelo.dao;

import java.util.Arrays;

import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;

public class Alquileres {

	// atributos
	
	private final int MAX_ALQUILERES = 5;
	private Alquiler[] alquileres;

	// constructor
	public Alquileres() {
		alquileres = new Alquiler[MAX_ALQUILERES];
	}

	// get alquiler

	

	/**
	 * @return the alquileres
	 */
	public Alquiler[] getAlquileres() {
		return alquileres.clone();
	}

	/**
	 * @return the mAX_ALQUILERES
	 */
	public int getMAX_ALQUILERES() {
		return MAX_ALQUILERES;
	}

	/**
	 * @param cliente
	 * @param turismo
	 */

	// abrir alquiler (buscarIndiceLibre, indiceNoSupera)

	public void abrirAlquiler (Cliente cliente, Turismo turismo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(turismo);// indiceConAlquiler
		if (indiceNoSuperaTamano(indice)) {
			alquileres[indice] = new Alquiler(cliente, turismo);
		} else {
			throw new ExcepcionAlquilerVehiculos("El array esta lleno");
		}
	}

	
	// private int buscarPrimerIndiceLibreComprobandoExistencia(Turismo turismo)
	private int buscarPrimerIndiceLibreComprobandoExistencia(Turismo turismo) {
		int indice = 0;
		boolean encontrado = false;
		while (indiceNoSuperaTamano(indice) && !encontrado) {
			if (alquileres[indice] == null) {
				encontrado = true;
			} else if (alquileres[indice].getTurismo().getMatricula().equals(turismo.getMatricula())
					&& !alquileres[indice].getTurismo().getDisponible()) {
				throw new ExcepcionAlquilerVehiculos("El turismo no esta disponible, ya esta alquilado");
			} else {
				indice++; // pasar a la siguiente posicion
			}
		}
		return indice;
	}

	// private boolean indiceNoSuperaTamaño( int indice)
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < alquileres.length;
	}

	public void cerrarAlquiler(Turismo turismo) {
		int indice = buscarIndiceAlquilerAbierto(turismo);
		if (indiceNoSuperaTamano(indice))
			alquileres[indice].cerrar();
		else
			throw new ExcepcionAlquilerVehiculos("No hay ningun alquiler Abierto");
	}

	// private int buscarIndiceAlquilerAbierto(Turismo turismo, Cliente cliente)
	private int buscarIndiceAlquilerAbierto(Turismo turismo) {
		int indice = 0;
		boolean encontradoAlquiler = false;
		while (indiceNoSuperaTamano(indice) && !encontradoAlquiler && alquileres[indice] != null) {
			if (alquileres[indice].getTurismo().getMatricula().equals(turismo.getMatricula()))
				encontradoAlquiler = true;
			else
				indice++;
		}
		return encontradoAlquiler ? indice : alquileres.length;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alquileres [MAX_ALQUILERES=" + MAX_ALQUILERES + ", alquileres=" + Arrays.toString(alquileres) + "]";
	}

	
	
	
	
	
	
	
	
	// public void abrirAlquiler(Cliente cliente, Turismo turismo) {
	//
	// int posicion = 0;
	// boolean posicionEncontrada = false;
	//
	// // Si el vehiculo esta disponible se busca hueco en array.
	//
	// // Recorrer array mientras t < y exitahuecolibres
	// while (posicion < alquileres.length && !posicionEncontrada) {
	// // Si la posicion esta vacia se puede asignar el alquiler.
	// if (alquileres[posicion] == null)
	// posicionEncontrada = true;// PosicionEncontrada
	// else if
	// (alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula()))
	// throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto");
	// else
	// turismo.setDisponible(false);
	// posicion++;
	// }
	//
	// // Si no ha encontrado un hueco vacio.
	// if (posicionEncontrada) {
	//
	// // se crea un nuevo alquiler new ( llama constructor )
	// alquileres[posicion] = new Alquiler(cliente, turismo);
	// System.out.println(" Se ha creado el alquiler correctamente");
	//
	// }
	//
	// else
	// throw new ExcepcionAlquilerVehiculos("El vehiculo no esta disponible.");
	//
	// }

	// cerrar alquiler

	/**
	 * @param cliente
	 * @param turismo
	 */

	//
	// public void cerrarAlquiler(Cliente cliente, Turismo turismo) {
	//
	// int posicion = 0;
	// boolean posicionEncontrada = false;
	//
	// // Buscar en el array posicion
	// while (posicion < alquileres.length && !posicionEncontrada) {// abre while
	// // comprobar si existe alquiler ( posicion array alquiler ! null )
	// if (alquileres[posicion] != null &&
	// // Comparar si alquiler existe ( dni buscado + matricula buscado=dni +
	// matricula
	// // array )
	// (alquileres[posicion].getCliente().getDni().equals(cliente.getDni()) // dni
	// cliente del alquiler =
	// // dniClienteBuscar
	// &&
	// alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula())))
	// { // matricula
	//
	// posicionEncontrada = true; // encontrado Alquiler
	//
	// } else // Si no es el alquiler, se pasa posicion.
	//
	// posicion++;
	//
	// } // cierre while
	//
	// if (posicionEncontrada) {
	//
	// alquileres[posicion].cerrar();
	//
	// System.out.println("Ha cerrado el aquiler correctamente");
	//
	// } else

	// throw new ExcepcionAlquilerVehiculos("No se ha encontrado ningun alquiler
	// abierto");
	//
	// }
}
