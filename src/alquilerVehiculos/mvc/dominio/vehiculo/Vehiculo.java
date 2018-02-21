package alquilerVehiculos.mvc.dominio.vehiculo;
import java.util.regex.*;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author crosanom version2
 *
 */

public class Vehiculo {

	
	private String matricula, marca, modelo;
	private boolean disponible = true; // un coche disponible

	// anadir los atributos de Vehiculo
	
	private final double  FACTOR_CILINDRADA=1200;
	private final double FACTOR_NUMERO_PLAZAS_=1;
	private final double FACTOR_PMA =10;
	private DatosTecnicosVehiculo datosTecnicos;
	
	//Constructor ()
	
	public Vehiculo(String matricula, String marca, String modelo,  DatosTecnicosVehiculo datosTecnicos) {
		
		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setDatosTecnicosVehiculo(datosTecnicos);

	}

	
	// constructor copia 
	
	public Vehiculo(Vehiculo vehiculo) {

	matricula=vehiculo.getMatricula();
	marca=vehiculo.getMarca();
	modelo=vehiculo.getModelo();
	datosTecnicos=vehiculo.getDatosTecnicos();
	
	}
	
	// get datos tecnicos 
	
	/**
	 * @return the fACTOR_CILINDRADA
	 */
	public double getFACTOR_CILINDRADA() {
		return FACTOR_CILINDRADA;
	}


	/**
	 * @return the fACTOR_NUMERO_PLAZAS_
	 */
	public double getFACTOR_NUMERO_PLAZAS_() {
		return FACTOR_NUMERO_PLAZAS_;
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
	public DatosTecnicosVehiculo getDatosTecnicos() {
		return datosTecnicos;
	}


	private void setDatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void setDatosTecnicosVehiculos(DatosTecnicosVehiculo datosTecnicosVehiculos) {
	 
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", disponible="
				+ disponible + ", FACTOR_CILINDRADA=" + FACTOR_CILINDRADA + ", FACTOR_NUMERO_PLAZAS_="
				+ FACTOR_NUMERO_PLAZAS_ + ", FACTOR_PMA=" + FACTOR_PMA + ", datosTecnicos=" + datosTecnicos + "]";
	}

	
	

	
	
}
