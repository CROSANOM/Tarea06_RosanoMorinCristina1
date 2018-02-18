package alquilerVehiculos.mvc.modelo.dao;

import java.util.Arrays;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;

public class Turismos {

	private Turismo[] turismos;
	private final int MAX_VEHICULOS = 5;

	public Turismos() {
		turismos = new Turismo[MAX_VEHICULOS];
	}

	public Turismo[] getTurismo() {
		return turismos.clone();
	}

	// metodo anadir Turismo (buscarPrimerIndiceLibre,indiceNosuperaTamaño)
	public void anadirTurismo(Turismo turismo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(turismo);
		if (indiceNoSuperaTamano(indice))
			turismos[indice] = new Turismo(turismo);
		else
			throw new ExcepcionAlquilerVehiculos("El array de  turismos esta lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistencia(Turismo turismo) {
		int indice = 0;
		boolean turismoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !turismoEncontrado) {
			if (turismos[indice] == null)
				turismoEncontrado = true;
			else if (turismos[indice].getMatricula().equals(turismo.getMatricula()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un turismo con esa matricula");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < turismos.length;
	}
	
// metodo de borrar Turismo (buscarIndiceTurismo (indice), indiceNoSuperaTamano, desplazarUnaPosicionHaciaIzquierda) 
	
	 public void borrarTurismo(String matricula) {
	        int indice = buscarIndiceTurismo(matricula);
	        if (indiceNoSuperaTamano(indice)) {
	            desplazarUnaPosicionHaciaIzquierda(indice);
	        } else {
	            throw new ExcepcionAlquilerVehiculos("El turismo no existe.");
	        }
	    }

	    private int buscarIndiceTurismo(String matricula) {
	        int indice = 0;
	        boolean turismoEncontrado = false;
	        while (indiceNoSuperaTamano(indice) && !turismoEncontrado) {
	            if (turismos[indice] != null && turismos[indice].getMatricula().equals(matricula)) {
	                turismoEncontrado = true;
	            } else {
	                indice++;
	            }
	        }
	        return indice;
	    }

	    private void desplazarUnaPosicionHaciaIzquierda(int indice) {//  pasar siguiente indice
	        for (int i = indice; i < turismos.length - 1 && turismos[i] != null; i++) {
	            turismos[i] = turismos[i + 1];
	        }
	    }

	
	// Metodo buscarTurismo ( buscarIndice,indiceNoSupera)
	public Turismo buscarTurismo(String matricula) {
		int indice = buscarIndiceTurismo(matricula);
		if (indiceNoSuperaTamano(indice))
			return new Turismo(turismos[indice]);
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
		return "Turismos [turismos=" + Arrays.toString(turismos) + ", MAX_VEHICULOS=" + MAX_VEHICULOS + "]";
	}

}
