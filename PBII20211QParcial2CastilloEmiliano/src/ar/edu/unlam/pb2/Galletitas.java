package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.Comestible;

public class Galletitas extends Producto implements Comestible {
	
	private String fechaDeElaboracion;
	private String fechaDeVencimiento;
	
	public Galletitas(Integer codigo, String descripcion, String fechaDeElaboracion, String fechaDeVencimiento, String marca, Double precio) {
		super(codigo, descripcion, marca, precio);
		this.fechaDeElaboracion=fechaDeElaboracion;
		this.fechaDeVencimiento=fechaDeVencimiento;	
	}

	public String getFechaDeElaboracion() {
		return fechaDeElaboracion;
	}

	public void setFechaDeElaboracion(String fechaDeElaboracion) {
		this.fechaDeElaboracion = fechaDeElaboracion;
	}

	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(String fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	
	

}
