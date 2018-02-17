package alquilerVehiculos.mvc.modelo.dao;

import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Turismo;


public class Alquileres {
	
		private Alquiler[] alquileres;
		private final int MAX_ALQUILERES = 20;

		public Alquileres() {
			alquileres = new Alquiler[MAX_ALQUILERES];
		}
	
// get alquiler 
		
		public Alquiler[] getAlquiler() {
			return alquileres.clone();
		}

	
		
		
// abrir alquiler 
	
		/**
		 * @param cliente
		 * @param turismo
		 */
		public void abrirAlquiler(Cliente clientes, Turismo turismos) {

			int posicion = 0;
			boolean posicionEncontrada = false;
			
			// Recorrer array mientras t < y exita huecolibres
			while (posicion < alquileres.length && !posicionEncontrada) {
				// Si la posicion esta vacia se puede asignar el alquiler.
				if (alquileres[posicion] == null)
					posicionEncontrada = true;// PosicionEncontrada
				else if (alquileres[posicion].getTurismo().getMatricula().equals(turismos.getMatricula()))
					throw new ExcepcionAlquilerVehiculos("Ya existe un alquiler abierto");
				else
					turismos.setDisponible(false);
				posicion++;
			}

	}
		
		
		
		// cerrar alquiler 
		
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

				alquileres[posicion].cerrar();

				System.out.println("Ha cerrado el aquiler correctamente");

			} else

				throw new ExcepcionAlquilerVehiculos("No se ha encontrado ningun alquiler abierto");

		}
	}


		
		

		


