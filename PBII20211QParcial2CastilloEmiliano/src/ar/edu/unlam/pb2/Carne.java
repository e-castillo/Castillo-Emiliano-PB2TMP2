package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.Comestible;

public class Carne extends Producto implements Comestible {
	
	private String fechaDeElaboracion;
	private String fechaDeVencimiento;
	private Double kilos;
	
	public Carne(Integer codigo, String descripcion, String fechaDeElaboracion, String fechaDeVencimiento, Double kilos, String marca, Double precio) {
		super(codigo, descripcion, marca, precio);
		this.fechaDeElaboracion=fechaDeElaboracion;
		this.fechaDeVencimiento=fechaDeVencimiento;	
		this.kilos=kilos;
	}

	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public String getFechaDeElaboracion() {
		return fechaDeElaboracion;
	}

	public Double getKilos() {
		return kilos;
	}

}
