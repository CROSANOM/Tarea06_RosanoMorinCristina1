package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author crosanom version2
 *
 */

// crear la clase abstract de vehiculo

public abstract class Vehiculo {

	private String matricula, marca, modelo;
	private boolean disponible = true; // un coche disponible

	// anadir los atributos de Vehiculo

	private DatosTecnicosVehiculo datosTecnicosVehiculos;

	protected final double FACTOR_CILINDRADA = 0;
	protected final double FACTOR_NUMERO_PLAZAS = 0;
	protected final double FACTOR_PMA = 0;

	// Constructor ()

	public Vehiculo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {

		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setDatosTecnicosVehiculo(datosTecnicos);

	}

	// constructor copia

	public Vehiculo(Vehiculo vehiculo) {

		matricula = vehiculo.getMatricula();
		marca = vehiculo.getMarca();
		modelo = vehiculo.getModelo();
		datosTecnicosVehiculos = vehiculo.getDatosTecnicosVehiculo();

	}

	// metodos abstract

	public abstract double getPrecioEspecifico();

	public abstract TipoVehiculo getTipoVehiculo();

	// Metodos DatosTecnicos

	/**
	 * @return the fACTOR_CILINDRADA
	 */
	public double getFACTOR_CILINDRADA() {
		return FACTOR_CILINDRADA;
	}

	/**
	 * @return the fACTOR_NUMERO_PLAZAS
	 */
	public double getFACTOR_NUMERO_PLAZAS() {
		return getFACTOR_NUMERO_PLAZAS();
	}

	/**
	 * @return the fACTOR_PMA
	 */
	public double getFACTOR_PMA() {
		return FACTOR_PMA;
	}

	/**
	 * @return the datosTecnicos
	 */
	public DatosTecnicosVehiculo getDatosTecnicosVehiculo() {
		return datosTecnicosVehiculos;
	}

	/**
	 * @param datosTecnicos
	 */
	private void setDatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {
		this.datosTecnicosVehiculos = new DatosTecnicosVehiculo(datosTecnicos);

	}
	// set (disponibilidad,matricula,modelo,

	/**
	 * @param disponible
	 *            the disponibilidad to set
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * @param matricula
	 */
	private void setMatricula(String matricula) {

		// Comprobar Matricula
		boolean matriculaCorrecta = false;
		matriculaCorrecta = compruebaMatricula(matricula);

		if (matriculaCorrecta) {
			this.matricula = matricula; // inicializar matricula
		} else
			throw new ExcepcionAlquilerVehiculos("La matricula No es correcta"); // lanzar excepción
	}

	/**
	 * @param marca
	 *            the marca to set
	 */
	private void setMarca(String marca) {

		if(marca!=null && !marca.equals(""))
		this.marca = marca;
		 else
		throw new ExcepcionAlquilerVehiculos("La marca no es valida");
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	private void setModelo(String modelo) {

		if (modelo!=null && !modelo.equals(""))
		this.modelo = modelo;
		 else
		 throw new ExcepcionAlquilerVehiculos("El modelo no es valido");
	}

	// Metodo para comprobar matricula usando expresión regular
	private boolean compruebaMatricula(String matricula) {
		boolean matriculaValida = false;

		Pattern matriculaPatron = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
		Matcher emparejador = matriculaPatron.matcher((matricula));

		matriculaValida = emparejador.matches();

		if (matriculaValida) {
			System.out.println("La matricula  es correcta");
		} else {
			System.out.println("La matricula es incorrecta ");
		}

		return matriculaValida;

	}

	// metodos getters
	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @return the disponibilidad
	 */
	public boolean getDisponible() {
		return disponible;
	}

	// toString actualizado con datosTecnicos

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", disponible="
				+ disponible + ", FACTOR_CILINDRADA=" + FACTOR_CILINDRADA + ", FACTOR_NUMERO_PLAZAS="
				+ FACTOR_NUMERO_PLAZAS + ", FACTOR_PMA=" + FACTOR_PMA + ", datosTecnicos=" + datosTecnicosVehiculos + "]";
	}

}
