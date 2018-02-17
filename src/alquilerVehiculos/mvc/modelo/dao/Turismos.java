package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;




public class Turismos {
	
	private Turismo[] turismos;
	private final int MAX_VEHICULOS = 20;

	public Turismos() {
		turismos = new Turismo[MAX_VEHICULOS];
	}
	
	public Turismo[] getTurismo() {
		return turismos.clone();
	}
	
	// refactorización del metodo anadir turismo de la tarea anterior
	public void anadirTurismo(Turismo turismo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(turismo);
		if (indiceNoSuperaTamano(indice))
			turismos[indice] = new Turismo(turismo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de  turismos esta lleno.");
	}
// define el metodo buscarPrimerIndice  usa en anadir Turismo 
	private int buscarPrimerIndiceLibreComprobandoExistencia(Turismo turismo) {
		int indice = 0;
		boolean turismoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !turismoEncontrado) {
			if (turismos[indice] == null)
				turismoEncontrado = true;
			else
				if (turismos[indice].getMatricula().equals(turismo.getMatricula()))
					throw new ExcepcionAlquilerVehiculos("Ya existe un turismo con esa matricula");
				else
					indice++;
		}
		return indice;
	}
	// define el metodo indiceNoSuperaTamano se usa  en borrar y en anadir 
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < turismos.length;
	}
	
	public void borrarTurismo(String matricula) {
		int indice = buscarIndiceTurismo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}
		else {
			throw new ExcepcionAlquilerVehiculos("El turismo a borrar no existe");
		}
	}

	private int buscarIndiceTurismo(String matricula) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado && turismos[indice] != null) {
			if (turismos[indice].getMatricula().equals(matricula))
				vehiculoEncontrado = true;
			else
				indice++;
		}
		return vehiculoEncontrado ? indice : turismos.length;
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < turismos.length - 1 && turismos[i] != null; i++) {
			turismos[i] = turismos[i+1];
		}
		if (indice == turismos.length - 1)
			turismos[turismos.length - 1] = null;
	}
	
	public Turismo buscarTurismo(String matricula) {
		int indice = buscarIndiceTurismo(matricula);
		if (indiceNoSuperaTamano(indice))
			return new Turismo(turismos[indice]);
		else
			return null;
	}

}
