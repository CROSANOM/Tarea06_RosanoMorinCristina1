package alquilerVehiculos.mvc.modelo.dominio;
import java.text.SimpleDateFormat;
import java.util.Date;// instanciar la clase Fecha y acceder a sus metodos

/**
 * @author crosanom
 *
 */

public class Alquiler {
	// atributos de la clase Alquiler
	private Cliente cliente;
	private Turismo turismo;
	private Date fecha;
	private int dias;

	private final int MS_DIA = 1000 * 60 * 60 * 24; // Calculo de los milisegundos por dia.
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/mm/yyyy"); // incialiazación del objeto
	private final double PRECIO_DIA = 30; // se incializa segun informacion dada

	// Constructores.
	public Alquiler(Cliente cliente, Turismo turismo) {
		this.cliente = cliente;
		this.turismo = turismo;
		this.fecha = new Date();
		this.dias = 0;
		this.turismo.setDisponible(false);

	}

	public Cliente getCliente() {
		return cliente;
	}

	public Turismo getTurismo() {
		return turismo;
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
 
	public void cerrar() {

		Date fechaActual = new Date();
		dias = difDias(fechaActual, fecha); // devuelve un numero de dias

		if (dias == 0) { // si la di ferencia de restar la fecha de alquiler y la de entrada es cero
			dias = +1;
		} else {
			dias = dias + 1; // si se ha alquilidado durante mas de un dia la diferencia de dias sera
			// difDias+1
		}

		this.turismo.setDisponible(true); // pone turismo disponible

	}

	// Punto 17 GetPrecio Metodo calcule el precio total ( 30 euros * Ndias +
	// cilindra/100 )

	public double getPrecio() { // obtener el precioDia segun regla de negocio

		return PRECIO_DIA * dias + turismo.getCilindrada() / 100;
	}

	// Punto18 Crear un método llamado toString y que devuelva un String que será la
	// representación del alquiler.

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alquiler [cliente=" + cliente + ", turismo=" + turismo + ", fecha=" + fecha + ", dias=" + dias
				+ ", MILI_SEG_DIAS=" + MS_DIA + ", FORMATO_FECHA=" + FORMATO_FECHA + ", PRECIO_DIA=" + PRECIO_DIA
				+ "]";
	}

}
