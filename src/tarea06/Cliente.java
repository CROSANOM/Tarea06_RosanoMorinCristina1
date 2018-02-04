package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Punto5  Crear la clase cliente con los atributos y visibilidad adecuados. 

public class Cliente {

	private String nombre, dni, direccion, localidad, codigoPostal;
	private int identificador;
	private static int numClientes = 0;

	// punto 6 ( Crear un constructor Cliente con cinco parámetros)
	public Cliente(String nombre, String dni, String direccion, String localidad, String codigoPostal) {

		boolean dniCorrecto = false;
		boolean codigoCorrecto = false;

		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		
		/* Comprobaciones de dni y de codigo postal */
		dniCorrecto = compruebaDni(dni);
		codigoCorrecto = compruebaCodigoPostal(codigoPostal);
		// Comprobar dni o lanzar excepcion.
		if (dniCorrecto) {
			this.dni = dni;
		} else
			throw new ExcepcionAlquilerVehiculos("El dni no es correcto.");
		// Comprobar codigo postal o lanzar excepción.
		if (codigoCorrecto) {
			this.codigoPostal = codigoPostal;

		} else
			throw new ExcepcionAlquilerVehiculos("El codigo postal no es correcto.");

		if (this.dni != null && this.codigoPostal != null) {
			// Contar nuevo cliente.
			this.identificador = numClientes++;
		}
	}

	// Punto 6 Crear constructor copia de Cliente

	public Cliente(Cliente cliente) {

		identificador = cliente.getIdentificador();
		nombre = cliente.getNombre();
		dni = cliente.getDni();
		direccion = cliente.getDireccion();
		localidad = cliente.getLocalidad();
		codigoPostal = cliente.getCodigoPostal();

	}

	// Crear metodos comprueba

	/* metodo privado comprueba dni */
	private static boolean compruebaDni(String dni) {

		boolean dniValidado = false; // declara variable que contendra valor emparejador.matches

		Pattern dniPatron = Pattern.compile("[0-9A-Z][0-9]{7}[A-Z]");/* expresionRegular */
		Matcher emparejador = dniPatron.matcher((dni));

		dniValidado = emparejador.matches(); // se guarda el resultado del metodo emparejador.matches en una variable

		if (dniValidado) { // if siempre valida a false
			System.out.println(" El dni es Correcto");

		} else {
			System.out.println("El dni es Incorrecto");

		}
		return dniValidado;

	}

	/* metodo privado comprueba codigo postal */
	private static boolean compruebaCodigoPostal(String codigoPostal) {

		boolean codigoPostalValidado = false;

		Pattern cpPatron = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}\n" + "\n" + "$");
		Matcher emparejador = cpPatron.matcher((codigoPostal));

		codigoPostalValidado = emparejador.matches(); // se guarda el resultado del método emparejador.matches en una
		// variable

		if (codigoPostalValidado) {
			System.out.println(" El codigo Postal es Correcto");
		} else {
			System.out.println("El codigo Postal NO es Correcto");
		}

		return codigoPostalValidado;

	}

	// Punto 7 Crear los métodos get para cada uno de los atributos

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @return the numClientes
	 */
	public static int getNumClientes() {
		return numClientes;
	}
	// punto 8 Crear el método toString que devuelva una representación de nuestro
	// cliente.

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + ", localidad=" + localidad
				+ ", codigoPostal=" + codigoPostal + ", identificador=" + identificador + "]";
	}

}
