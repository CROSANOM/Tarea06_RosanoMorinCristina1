package tarea05;

import java.util.regex.*;

/**
 * @author crosanom version1
 *
 */
// punto 9 Crear la clase Turismo con sus atributos
public class Turismo {

	private String matricula, marca, modelo;
	private int cilindrada;
	private boolean disponibilidad = true; // un coche disponible

	// punto 10 Constructor con Parametros inicializa si Matricula correcta y
	// Cilindrada Mayor Cero

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param cilindrada
	 */
	public Turismo(String matricula, String marca, String modelo, int cilindrada) {

		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;

		// constructor

		// Comprobar la cilindrada

		if (cilindrada > 0) {
			this.cilindrada = cilindrada;
		} else

			throw new ExcepcionAlquilerVehiculos("La cilindrada no es correcta");

		// Comprobar Matricula

		boolean matriculaCorrecta = false;
		matriculaCorrecta = compruebaMatricula(matricula);

		if (matriculaCorrecta) {
			this.matricula = matricula; // inicializar matricula
		} else
			throw new ExcepcionAlquilerVehiculos("La matricula No es correcta"); // lanzar excepción

	}// cierraConstructor

	// Constructor Copia

	public Turismo(Turismo turismo) {

		matricula = turismo.getMatricula();
		marca = turismo.getMarca();
		modelo = turismo.getModelo();
		cilindrada = turismo.getCilindrada();
		disponibilidad = turismo.isDisponibilidad();

	}

	// Metodo para comprobar matricula usando expresión regular

	boolean matriculaCorrecta = false;

	/* metodo privado comprueba matricula es estatico no requiere de un objeto */
	private static boolean compruebaMatricula(String matricula) {

		boolean matriculaValidada = false;

		Pattern matriculaPatron = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
		Matcher emparejador = matriculaPatron.matcher((matricula));

		matriculaValidada = emparejador.matches();

		if (matriculaValidada) {
			System.out.println("La matricula  es correcta");

		} else {
			System.out.println("La matricula es incorrecta ");

		}

		return matriculaValidada;

		// punto 11 metodos getter de los atributos
	}

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
	 * @return the cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * @return the disponibilidad
	 */
	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	// punto11 Crear un método llamado toString que devolverá un String y será la
	// representación del turismo

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Turismo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", cilindrada="
				+ cilindrada + ", disponibilidad=" + isDisponibilidad() + "]";
	}

	/**
	 * @param disponibilidad
	 *            the disponibilidad to set
	 */
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}
