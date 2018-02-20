package alquilerVehiculos.mvc.modelo.dao;

import java.util.Arrays;

import alquilerVehiculos.mvc.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public class Vehiculos {

	private Vehiculo[] vehiculos;
	private final int MAX_VEHICULOS = 5;

	// constructor
	public Vehiculos() {
		vehiculos = new Vehiculo[MAX_VEHICULOS];
	}

	public Vehiculo[] getVehiculo() {
		return vehiculos.clone();
	}

	// metodo anadir Vehiculo (buscarPrimerIndiceLibre,indiceNosuperaTamaño)
	public void anadirVehiculo(Vehiculo vehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
		if (indiceNoSuperaTamano(indice))
			vehiculos[indice] = new Vehiculo(vehiculo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de  vehiculos esta lleno.");
	}
// metodo buscarPrimerIndiceLibre ( indiceNoSupera)
	private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
		int indice = 0;
		boolean VehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !VehiculoEncontrado) {
			if (vehiculos[indice] == null)
				VehiculoEncontrado = true;
			else if (vehiculos[indice].getMatricula().equals(vehiculo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un turismo con esa matricula");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < vehiculos.length;
	}

	// metodo de borrar Vehiculo (buscarIndiceTurismo (indice), indiceNoSuperaTamano,
	// desplazarUnaPosicionHaciaIzquierda)

	public void borrarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El Vehiculo no existe.");
		}
	}

	private int buscarIndiceVehiculo(String matricula) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado && vehiculos[indice]!=null) {
			if (vehiculos[indice].getMatricula().equals(matricula)) {
				vehiculoEncontrado = true;
			} else {
				indice++;
			}
		}
		return vehiculoEncontrado ? indice: vehiculos.length;
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {// pasar siguiente indice
		for (int i = indice; i < vehiculos.length - 1 && vehiculos[i] != null; i++) {
			vehiculos[i] = vehiculos[i + 1];
		}
	}

	// Metodo buscarTurismo ( buscarIndice,indiceNoSupera)
	public Vehiculo buscarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice))
			return new Vehiculo(vehiculos[indice]);
		else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculos [vehiculos=" + Arrays.toString(vehiculos) + ", MAX_VEHICULOS=" + MAX_VEHICULOS + "]";
	}

}
