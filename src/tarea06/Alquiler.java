package tarea05;

import java.text.SimpleDateFormat;
import java.util.Date;// instanciar la clase Fecha y acceder a sus metodos

/**
 * @author crosanom
 *
 */

// punto13 Crear la clase Alquiler con sus atributos.

public class Alquiler {
	// atributos de la clase Alquiler
	private Cliente cliente;
	private Turismo turismo;
	private Date fecha;
	private int dias;

	private final int MILI_SEG_DIAS = 1000 * 60 * 60 * 24;// se declará los MiliSegundoDias
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy");// incialiazación del objeto
	private final double PRECIO_DIA = 30;// se incializa segun infor dada

	int guardaDiferenciaDias = 0;

	/*
	 * punto14 Crear un constructor clase Alquiler con Cliente Turismo como
	 * parametros y que al crear un nuevo alquiler ponga la fecha actual del
	 * sistema, los dias a cero y vehiculo no disponible.
	 */

	public Alquiler(Cliente cliente, Turismo turismo) {
		this.cliente = cliente;
		this.turismo = turismo;
		this.fecha = new Date();
		this.dias = 0;
		this.turismo.setDisponibilidad(false);

	}

	/*
	 * punto15 Crear los métodos get para los atributos de la clase Alquiler
	 * Get(cliente, turismo,fecha, dias, MILISEG_DIA,FORMATO_FECHA PRECIO_DIA
	 */

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

	public int getMILISEG_DIAS() {
		return MILI_SEG_DIAS;
	}

	public SimpleDateFormat getFORMATO_FECHA() {
		return FORMATO_FECHA;
	}

	public double getPRECIO_DIA() {
		return PRECIO_DIA;
	}

	/*
	 * punto16 Crear un método close que cerrará el alquiler, para lo que partiendo
	 * de la fecha actual y la fecha en que se realizó el alquiler, calcule el
	 * número de días -si se devuelve el mismo día contará como 1 día- y ponga el
	 * turismo como disponible. Para ello crea un método privado llamado difDias y
	 * que devuelva la diferencia en días entre dos fechas y luego utilizalo en el
	 * método close
	 */

	// metodo para DifDias url
	

	private int diferenciaDias(Date fechaFin, Date fechaInicio) {
		long milisegundos = fechaFin.getTime() - fechaInicio.getTime(); // ojo getTime devuelve los milisegundos
		long dias = milisegundos / MILI_SEG_DIAS;
		return (int) dias; // ( int) casting pasamos long a int
	}

	// metodo Close Cierra Alquiler

	public void cerrarAlquiler() {

		Date fechaActual = new Date();
		dias = diferenciaDias(fechaActual, fecha); // devuelve un numero de dias

		if (dias == 0) { // si la di ferencia de restar la fecha de alquiler y la de entrada es cero
			dias = +1;
		} else {
			dias = dias + 1; // si se ha alquilidado durante mas de un dia la diferencia de dias sera
			// difDias+1
		}

		this.turismo.setDisponibilidad(true); // pone turismo disponible

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
				+ ", MILI_SEG_DIAS=" + MILI_SEG_DIAS + ", FORMATO_FECHA=" + FORMATO_FECHA + ", PRECIO_DIA=" + PRECIO_DIA
				+ ", guardaDiferenciaDias=" + guardaDiferenciaDias + "]";
	}

}
