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
				synchronized (m) {
					m.setMensaje(m.getMensaje()+100);
					m.notify();
				}
			}
			else
			{
				yield();
			}
		}
	}

	//	public void run()
	//	{
	//		while(true)
	//		{
	//			if(buffer.getCantidadClientes()==0)
	//				break;
	//			Mensaje m=buffer.atender();
	//			synchronized (m) {
	//				m.setMensaje(m.getMensaje()+100);
	//				m.notifyAll();
	//			}
	//		}
	//	}
}
