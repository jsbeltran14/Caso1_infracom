package Caso1.Main;

import java.util.Queue;

public class Cliente extends Thread{

	private int id;
	
	private int nMensajes;
	
	private Queue<Mensaje> mensajes;
	
	private Buffer buffer;
	
	public Cliente(int pId, int pNMensajes, Buffer pBuffer){
		id = pId;
		nMensajes = pNMensajes;
		buffer = pBuffer;
		for (int i = 0; i < nMensajes; i++) {
			mensajes.add(new Mensaje());
		}
	}
	
	public void run(){
		while(!mensajes.isEmpty())
		{
			Mensaje x = mensajes.poll();
			synchronized (x) {
				buffer.almacenarMensaje(x);
				try {x.wait();} catch (InterruptedException e) {e.printStackTrace();}
			}
			System.out.println("El valor del mensaje ahora es: " + x.getMensaje());
		}
		buffer.retirarCliente();
		System.out.println("Cliente retirado");
	}
	
	public int darId(){
		return id;
	}
	
	
}
