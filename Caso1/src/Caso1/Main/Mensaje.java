package Caso1.Main;

public class Mensaje {
	
	public final static int VALOR_INICIAL = 100;
	
	private int mensaje;
	
	private int id;
	
	public Mensaje(int id){
		this.id = id;
		mensaje = VALOR_INICIAL;
	}

	public int getMensaje() {
		return mensaje;
	}

	public void setMensaje(int mensaje) {
		this.mensaje = mensaje;
	}
	
	public int getId()
	{
		return id;
	}
}
