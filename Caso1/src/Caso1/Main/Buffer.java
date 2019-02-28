package Caso1.Main;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

	private int numeroClientes;
	private final int tamanioBuffer;
	private Queue<Mensaje> mensajes;

	public Buffer(int pNumeroClientes, int ptamanio){
		numeroClientes = pNumeroClientes;
		tamanioBuffer = ptamanio;
		mensajes = new LinkedList<Mensaje>();
	}
	
	public int getCantidadClientes()
	{
		return numeroClientes;
	}
	
	public synchronized void almacenarMensaje(Mensaje mensaje)
	{
		while(tamanioBuffer == mensajes.size())
		{
			try {wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		mensajes.offer(mensaje);
	}
	
	public synchronized Mensaje atender()
	{
		return mensajes.poll();
	}
	
	public synchronized void retirarCliente()
	{
		numeroClientes--;
	}

}
