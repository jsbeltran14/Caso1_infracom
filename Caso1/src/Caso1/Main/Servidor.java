package Caso1.Main;



public class Servidor extends Thread{
	private int id;
	private Buffer buffer;

	public Servidor(int id, Buffer buffer)
	{
		this.id=id;
		this.buffer=buffer;
	}

	public void run(){
		while(buffer.getCantidadClientes()>0)
		{
			Mensaje m = buffer.atender();
			if(m != null)
			{
				System.out.println("Servidor	#" + id + " | Modificando el mensaje #" + m.getId());
				synchronized (m) {
					m.setMensaje(m.getMensaje()+100);
					m.notify();
				}
				yield();
			}
		}
	}
}
