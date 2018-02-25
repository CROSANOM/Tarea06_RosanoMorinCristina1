package alquilerVehiculos.modelo;

import alquilerVehiculos.mvc.modelo.dao.Alquileres;
import alquilerVehiculos.mvc.modelo.dao.Clientes;
import alquilerVehiculos.mvc.modelo.dao.Vehiculos;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.DatosTecnicosVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * @author crosanom
 *
 */
/**
 * @author crosanom
 *
 */
public class AlquilerVehiculos implements IModeloAlquilerVehiculos {
	// atributos
	private Clientes clientes;
	private Vehiculos vehiculos;
	private Alquileres alquileres;

	// constructor
	public AlquilerVehiculos() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		alquileres = new Alquileres();
	}

	// Metodos getters de atributos de AlquilerVehiculos
	// vehiculos-alquileres-clientes

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#getClientes()
	 */
	@Override
	public Clientes getClientes() {
		return clientes;
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#getVehiculos()
	 */
	@Override
	public Vehiculos getVehiculos() {
		return vehiculos;
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#getAlquileres()
	 */
	@Override
	public Alquileres getAlquileres() {
		return alquileres;
	}

	// Getters clientes, vehiculos, alquileres : return [ ] )

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#ObtenerCliente()
	 */
	@Override
	public Cliente[] ObtenerCliente() {
		return clientes.getClientes();
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#ObtenerVehiculos()
	 */
	@Override
	public Vehiculo[] ObtenerVehiculos() {
		return vehiculos.getVehiculo();
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#obtenerAlquileres()
	 */
	@Override
	public Alquiler[] obtenerAlquileres() {
		return alquileres.getAlquileres();
	}

	// metodos clientes ( anadir, borrar, buscar )

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#anadirCliente(alquilerVehiculos.mvc.modelo.dominio.Cliente)
	 */
	@Override
	public void anadirCliente(Cliente cliente) {
		clientes.anadirCliente(cliente);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#borrarCliente(java.lang.String)
	 */
	@Override
	public void borrarCliente(String dni) {
		clientes.borrarCliente(dni);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#buscarCliente(java.lang.String)
	 */
	@Override
	public Cliente buscarCliente(String dni) {
		return clientes.buscarCliente(dni);
	}

	// metodos de los Vehiculos
	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#anadirVehiculo(alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo, alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo)
	 */
	@Override
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		vehiculos.anadirVehiculo(vehiculo, tipoVehiculo);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#borrarVehiculo(java.lang.String)
	 */
	@Override
	public void borrarVehiculo(String matricula) {
		vehiculos.borrarVehiculo(matricula);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#buscarVehiculo(java.lang.String)
	 */

	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		return vehiculos.buscarVehiculo(matricula);
	}

	// metodos para los alquileres

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#abrirAlquiler(alquilerVehiculos.mvc.modelo.dominio.Cliente, alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	@Override
	public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo) {
		alquileres.abrirAlquiler(cliente, vehiculo);
	}

	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#cerrarAlquiler(alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo)
	 */
	@Override
	public void cerrarAlquiler(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#toString()
	 */
	@Override
	public String toString() {
		return "AlquilerVehiculos [clientes=" + clientes + ", vehiculos=" + vehiculos + ", alquileres=" + alquileres
				+ "]";
	}

	// Metodo con datos de pruebas
	/* (non-Javadoc)
	 * @see alquilerVehiculos.modelo.IModeloAlquilerVehiculos#anadirDatosPrueba()
	 */
	@Override
	public void anadirDatosPrueba() {
		System.out.println("Prueba con datos del sistema, PRUEBA1 ");

		// Cliente (String nombre, String dni, DireccionPostal (String calle, String
		// localidad, String codigoPostal)
		Cliente clientep1 = new Cliente("Manolo", "75675656T", new DireccionPostal("Pandereta", "Chiclana", "11345"));
		Cliente clientep2 = new Cliente("Manoli", "75675656R", new DireccionPostal("Oaa", "Chiclana", "11345"));
		Cliente clientep3 = new Cliente("Manolo", "75675654T", new DireccionPostal("Pandereta", "Chiclana", "11345"));
		Cliente clientep4 = new Cliente("Manolo", "65675656T", new DireccionPostal("Pandereta", "Chiclana", "11345"));

		anadirCliente(clientep1);
		anadirCliente(clientep2);
		anadirCliente(clientep3);
		//comprobar excepcion anadir cliente repetido
//		anadirCliente(clientep3);
//
		System.out.println("Imprimir clienteP3" + clientep3.toString());

		// Vehiculo public Vehiculo(String matricula, String marca, String modelo,
		// DatosTecnicosVehiculo (int cilindrada, int numerosPlazas, int pma)) {
		//anadir tipoVehiculo

		Vehiculo vehiculop1 = TipoVehiculo.AUTOBUS.getInstancia("2223GTR", "MarcaBus", "busModelo",
				new DatosTecnicosVehiculo(1200, 72, 120));
		Vehiculo vehiculop2 = TipoVehiculo.DECARGA.getInstancia("2223TTR", "Pegaso", "camionModelo",
				new DatosTecnicosVehiculo(1200, 3, 500));
		Vehiculo vehiculop3 = TipoVehiculo.TURISMO.getInstancia("2223TTT", "Wolskwagen", "polo",
				new DatosTecnicosVehiculo(1200, 1, 500));

		System.out.println("Imprimir Vehiculos" + vehiculop1.toString() + "\n"+ vehiculop2.toString());
		
		Alquiler alquiler =new Alquiler (clientep1,vehiculop2);
		
		System.out.println("Imprimir alquiler" + alquiler.toString() + "\n"+ vehiculop2.toString());

		System.out.println("Esta disponible "+vehiculop2 +vehiculop2.getDisponible());
		
		Vehiculo vehiculop4 = TipoVehiculo.AUTOBUS.getInstancia("2223TDT", "MIAUTOBUS", "polo",
				new DatosTecnicosVehiculo(1200, 1, 500));
		
		Vehiculo vehiculop5 = TipoVehiculo.AUTOBUS.getInstancia("2223TMT", "MIAUTOBUS", "ADR",
				new DatosTecnicosVehiculo(1200, 1, 500));


		System.out.println(vehiculop4 );
		
		// Vehiculo vehiculop4 = TipoVehiculo.DECARGA.getInstancia("2223TTR", "Pegaso",
		// "camionModelo",
		// new DatosTecnicosVehiculo(1200, 3, 500));

		anadirVehiculo(vehiculop1, TipoVehiculo.AUTOBUS);
		anadirVehiculo(vehiculop2, TipoVehiculo.DECARGA);
		anadirVehiculo(vehiculop3, TipoVehiculo.TURISMO);
		anadirVehiculo(vehiculop4,TipoVehiculo.AUTOBUS);
		anadirVehiculo(vehiculop5,TipoVehiculo.DECARGA);
		
		

// alquiler abrir / cerrar
//
		abrirAlquiler(clientep4, vehiculop3);
		cerrarAlquiler(vehiculop1);

		abrirAlquiler(clientep1, vehiculop1);


		cerrarAlquiler(vehiculop3);
		cerrarAlquiler(vehiculop1);
		

	}

}
