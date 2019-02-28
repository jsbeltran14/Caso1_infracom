package Caso1.Main;

import java.util.Queue;

public class Buffer {

	private int numeroClientes;

	private int tamanioBuffer;

	private Queue<Mensaje> mensajes;

	public Buffer(int pNumeroClientes, int ptamanio){
		numeroClientes = pNumeroClientes;
		tamanioBuffer = ptamanio;
	}

}
