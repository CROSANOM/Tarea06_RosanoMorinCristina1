package alquilerVehiculos.mvc.modelo.dominio;

import java.util.regex.*;

/**
 * @author crosanom version1
 *
 */

public class Turismo {

	private String matricula, marca, modelo;
	private int cilindrada;
	private boolean disponible = true; // un coche disponible

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param cilindrada
	 */
	public Turismo(String matricula, String marca, String modelo, int cilindrada) {
		
		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);

	}

	// Constructor Copia
	public Turismo(Turismo turismo) {

		matricula = turismo.getMatricula();
		marca = turismo.getMarca();
		modelo = turismo.getModelo();
		cilindrada = turismo.getCilindrada();
		disponible = turismo.getDisponible();

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
	public boolean getDisponible() {
		return disponible;
	}

	/**
	 * @param disponible
	 *            the disponibilidad to set
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * @param matricula the matricula to set
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
	 * @param marca the marca to set
	 */
	private void setMarca(String marca) {
		
		//if (marca!=null && marca.equals(""))
			this.marca = marca;
		//else 
			//throw new ExcepcionAlquilerVehiculos("La marca no es valida");
	}

	/**
	 * @param modelo the modelo to set
	 */
	private void setModelo(String modelo) {
		
		//if (modelo!=null && modelo.equals(""))
			this.modelo = modelo;
		//else 
			//throw new ExcepcionAlquilerVehiculos("El modelo no es valido");
	}

	/**
	 * @param cilindrada the cilindrada to set
	 */
	private void setCilindrada(int cilindrada) {
		
		// Comprobar la cilindrada
		if (cilindrada > 0) {
			this.cilindrada = cilindrada;
		} else
			throw new ExcepcionAlquilerVehiculos("La cilindrada no es correcta");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Turismo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", cilindrada="
				+ cilindrada + ", disponibilidad=" + getDisponible() + "]";
	}
	
	
	
}
