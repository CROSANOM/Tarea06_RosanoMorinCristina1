/**
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author crosanom
 *
 */
public enum TipoVehiculo {

	TURISMO("Turismo") {
		
		public Turismo getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicosVehiculo) {
	return new Turismo(matricula,marca,modelo, datosTecnicosVehiculo);
		}
		
	},
	DECARGA("Vehiculo de Carga") {
		public DeCarga getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicosVehiculo) {
			return new DeCarga(matricula,marca,modelo,datosTecnicosVehiculo);
		}
	},
	
	AUTOBUS("Autobus") {
		public Autobus getInstancia(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicosVehiculo) {
			return new Autobus(matricula,marca,modelo, datosTecnicosVehiculo);
		}
	};
	
		

	private String tipoVehiculo;

	private TipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String toString() {
		return tipoVehiculo;
	}

	public static TipoVehiculo getTipoVehiculosSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Ordinal del tipo de Vehiculo no válido");
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}

	// metodo abstracto

	public abstract Vehiculo getInstancia(String matricula, String marca, String modelo,
			DatosTecnicosVehiculo datosTecnicosVehiculo);

}
