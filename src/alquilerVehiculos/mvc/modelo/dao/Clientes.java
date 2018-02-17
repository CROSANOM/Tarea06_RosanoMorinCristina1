package alquilerVehiculos.mvc.modelo.dao;


import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public class Clientes {

	private Cliente[] clientes;
	private final int MAX_CLIENTES = 10;

	// constructor

	public Clientes() {
		clientes = new Cliente[MAX_CLIENTES];
	}

	//

	public Cliente[] getClientes() {
		return clientes.clone();
	}

	// refactorización dl metodo anadirCliente de tarea5 
	
	public void anadirCliente(Cliente cliente) {
		//declara una variable indice
		int indice;
		
		// varible indice toma valor de metodo buscar primer indiceLibre
		indice= buscarPrimerIndiceLibreComprobandoExistencia(cliente);
		
		if (indiceNoSuperaTamano(indice))// indice no supera tamaño 
			clientes[indice] = new Cliente(cliente);
		else
			throw new ExcepcionAlquilerVehiculos("El array de clientes esta lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistencia(Cliente cliente) {
		int indice = 0;
		boolean clienteEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
			if (clientes[indice] == null)
				clienteEncontrado = true;
			else if (clientes[indice].getDni().equals(cliente.getDni()))
				throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI");
			else
				indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < clientes.length;
	}

	public void borrarCliente(String dni) {
		int indice = buscarIndiceCliente(dni);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new ExcepcionAlquilerVehiculos("El cliente a borrar no existe");
		}
	}

	private int buscarIndiceCliente(String dni) {
		int indice = 0;
		boolean clienteEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !clienteEncontrado && clientes[indice] != null) {
			if (clientes[indice].getDni().equals(dni))
				clienteEncontrado = true;
			else
				indice++;
		}
		return clienteEncontrado ? indice : clientes.length;
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < clientes.length - 1 && clientes[i] != null; i++) {
			clientes[i] = clientes[i + 1];
		}
		if (indice == clientes.length - 1)
			clientes[clientes.length - 1] = null;
	}

	public Cliente buscar(String dni) {
		int posicion = buscarIndiceCliente(dni);
		if (indiceNoSuperaTamano(posicion))
			return new Cliente(clientes[posicion]);
		else
			return null;
	}

	
	
	
	
}