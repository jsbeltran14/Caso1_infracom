package Caso1.Main;

import java.util.LinkedList;
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
		mensajes=new LinkedList<>();
		for (int i = 0; i < nMensajes; i++) {
			mensajes.add(new Mensaje(i));
		}
	}

	public void run(){
		while(!mensajes.isEmpty())
		{
			Mensaje x = mensajes.poll();
			System.out.println("Cliente		#" + id + " | Valor del mensaje #" + x.getId() + ": " + x.getMensaje());
			synchronized (x) {
				buffer.almacenarMensaje(x);
				try {x.wait();} catch (InterruptedException e) {e.printStackTrace();}
			}
			System.out.println("Cliente		#" + id + " | Valor del mensaje #" + x.getId() + ": " + x.getMensaje());
		}
		buffer.retirarCliente();
		System.out.println("Cliente		#" + id + " | Retirada");
	}

	public int darId(){
		return id;
	}


}
