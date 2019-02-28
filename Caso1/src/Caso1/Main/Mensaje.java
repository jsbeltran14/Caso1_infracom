package Caso1.Main;

public class Mensaje {
	
	public final static int VALOR_INICIAL = 100;
	
	private int mensaje;
	
	public Mensaje(){
		mensaje = VALOR_INICIAL;
	}

	public int getMensaje() {
		return mensaje;
	}

	public void setMensaje(int mensaje) {
		this.mensaje = mensaje;
	}
}
