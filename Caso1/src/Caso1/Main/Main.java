package Caso1.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFileChooser;

public class Main {
	
	private static int numeroClientes;
	private static int numeroServidores;
	private static int numeroConsultas;
	private static int tamanioBuffer;
	
	private static Buffer buffer;
	
	private static File archivo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leerArchivo();
		buffer = new Buffer(numeroClientes, tamanioBuffer);
		for (int i = 0; i < numeroClientes; i++) {
			new Cliente(i, numeroConsultas, buffer).start();;
		}
		for (int i = 0; i < numeroServidores; i++) {
			new Servidor(i, buffer).start();
		}
	}
	
	public static void leerArchivo(){
		JFileChooser fc = new JFileChooser("./data");
		int resultado = fc.showOpenDialog(fc );
		 
		
		if( resultado == JFileChooser.APPROVE_OPTION)
		{
			archivo = fc.getSelectedFile( );
		}
		Properties p = new Properties();

		try {
			p.load(new FileReader(fc.getSelectedFile().getPath()));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		setNumeroClientes(Integer.parseInt(p.getProperty("numero.clientes")));
		setNumeroServidores(Integer.parseInt(p.getProperty("numero.servidores")));	
		setNumeroConsultas(Integer.parseInt(p.getProperty("numero.consultas.cliente")));
		setTamanioBuffer(Integer.parseInt(p.getProperty("tamanio.buffer")));
		System.out.println(numeroClientes);
		System.out.println(numeroServidores);
		System.out.println(numeroConsultas);
		System.out.println(tamanioBuffer);
	}

	public static int getNumeroClientes() {
		return numeroClientes;
	}

	public static void setNumeroClientes(int numeroClientes) {
		Main.numeroClientes = numeroClientes;
	}

	public static int getNumeroServidores() {
		return numeroServidores;
	}

	public static void setNumeroServidores(int numeroServidores) {
		Main.numeroServidores = numeroServidores;
	}

	public static int getNumeroConsultas() {
		return numeroConsultas;
	}

	public static void setNumeroConsultas(int numeroConsultas) {
		Main.numeroConsultas = numeroConsultas;
	}

	public static int getTamanioBuffer() {
		return tamanioBuffer;
	}

	public static void setTamanioBuffer(int tamanioBuffer) {
		Main.tamanioBuffer = tamanioBuffer;
	}

}
