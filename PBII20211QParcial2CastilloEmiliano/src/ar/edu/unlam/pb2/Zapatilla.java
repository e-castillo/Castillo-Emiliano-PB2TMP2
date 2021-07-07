package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.Indumentaria;

public class Zapatilla extends Producto implements Indumentaria {

	private String talle;
	private String color;
	
	public Zapatilla(Integer codigo, String descripcion, String talle, String marca, String color, Double precio) {
		super(codigo, descripcion, marca, precio);
		this.talle=talle;
		this.color=color;
	}
		
	public String getColor() {
		return color;
	}

	@Override
	public String getTalle() {
		return talle;
	}

}
