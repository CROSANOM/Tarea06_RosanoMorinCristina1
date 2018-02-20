package alquilerVehiculos.mvc.modelo.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;// instanciar la clase Fecha y acceder a sus metodos

import alquilerVehiculos.mvc.dominio.vehiculo.Vehiculo;

/**
 * @author crosanom
 *
 */

public class Alquiler {
	// atributos de la clase Alquiler
	private Cliente cliente;
	private Vehiculo vehiculo;
	private boolean alquilerAbierto;
	private Date fecha;
	private int dias;

	private final int MS_DIA = 1000 * 60 * 60 * 24; // Calculo de los milisegundos por dia.
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy"); // incialiazación del objeto
	private final double PRECIO_DIA = 30.0; // se incializa segun informacion dada

	// Constructores con set VehiculoDisponible.
	/**
	 * @param cliente
	 * @param vehiculo
	 */
	public Alquiler(Cliente cliente, Vehiculo vehiculo) {

		if (vehiculo.getDisponible()) {
			vehiculo.setDisponible(false);// vehiculo no disponible
			alquilerAbierto = true;
			SetTurismo(vehiculo);
			SetCliente(cliente);
			fecha = new Date();
			dias = 0;

		} else {

			throw new ExcepcionAlquilerVehiculos("El vehiculo no esta disponible");
		}

	}// f const
	
 // constructor copia 
	public Alquiler(Alquiler alquiler) {

		vehiculo = alquiler.getTurismo();
		cliente = alquiler.getCliente();
		dias = alquiler.getDias();
		fecha = alquiler.getFecha();

	}

	// getters

	public Cliente getCliente() {
		return new Cliente (cliente);
	}

	public Vehiculo getTurismo() {
		return new Vehiculo (vehiculo);
	}

	public Date getFecha() {
		return fecha;
	}

	public int getDias() {
		return dias;
	}

	// Calculo de dias.
	private int difDias(Date fechaFin, Date fechaInicio) {
		long milisegundos = fechaFin.getTime() - fechaInicio.getTime(); // ojo getTime devuelve los milisegundos
		long dias = milisegundos / MS_DIA;
		return (int) dias; // ( int) casting pasamos long a int
	}

	// metodos alquiler cerrar-GetPrecio- obtenerEstadoAlquiler
    
	//cerrar
	public void cerrar() {
		Date fechaActual = new Date();
		dias = difDias(fechaActual, fecha); // devuelve un numero de dias
		if (dias == 0) { // si la di ferencia de restar la fecha de alquiler y la de entrada es cero
			dias = 1;
		} else {
			dias = dias + 1; // si se ha alquilado durante mas de un dia la diferencia de dias sera
			// difDias+1
		}
		this.vehiculo.setDisponible(true);
		obtenerEstadoAlquiler();// pone vehiculo disponible
	}

	// getPrecio
	public double getPrecio() { // obtener el precioDia segun regla de negocio
		return PRECIO_DIA * dias + vehiculo.getCilindrada() / 100;
	}

	
	
	// obtenerEstadoAlquiler ( devuelve el estado ) 
	
	public String obtenerEstadoAlquiler() {
		String estado= alquilerAbierto ? "Abierto":"Cerrado";
		return estado;
	}
	
	// setter Cliente y de Vehiculos ( se usa mas adelante )

	private void SetCliente(Cliente cliente) {

		if (cliente != null)
			this.cliente = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El alquiler necesita un cliente");
	}

	//
	private void SetTurismo(Vehiculo vehiculo) {
		if (vehiculo != null) {
			this.vehiculo = new Vehiculo(vehiculo);
		} else {
			throw new ExcepcionAlquilerVehiculos("El alquiler necesita un vehiculo, no hay vehiculo");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alquiler [cliente=" + cliente + ", vehiculo=" + vehiculo + ", fecha=" + fecha + ", dias=" + dias
				+ ", MILI_SEG_DIAS=" + MS_DIA + ", FORMATO_FECHA=" + FORMATO_FECHA + ", PRECIO_DIA=" + PRECIO_DIA + "]";
	}

}
