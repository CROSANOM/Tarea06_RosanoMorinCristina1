/**
 * 
 */
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import alquilerVehiculos.mvc.dominio.vehiculo.Vehiculo;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author crosanom
 *
 */
public enum TipoVehiculo {

	TURISMO("Turismo") {
		public Turismo getInstancia(Vehiculo vehiculo) {
			return new Turismo(vehiculo);
		}
	},
	DECARGA("Vehiculo de Carga") {
		public DeCarga getInstancia(Vehiculo vehiculo) {
			return new DeCarga(vehiculo);
		}
	},
	AUTOBUS("Autobus") {
		public Autobus getInstancia(Vehiculo vehiculo) {
			return new Autobus(vehiculo);
		}
	};

	private String tipoVehiculo;

	private TipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String toString() {
		return tipoVehiculo;
	}

	public static TipoVehiculo getTipoTrabajoSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionAlquilerVehiculos("Ordinal del tipo de Vehiculo no válido");
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}

}
