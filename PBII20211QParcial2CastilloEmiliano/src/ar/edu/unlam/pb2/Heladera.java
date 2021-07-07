package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.Electrodomestico;

public class Heladera extends Producto implements Electrodomestico {

	private Boolean isNoFrost;
	private Integer garantia;
	
	public Heladera(Integer codigo, String descripcion, Boolean isNoFrost, Integer garantia, String marca, Double precio) {
		super(codigo, descripcion, marca, precio);
		this.isNoFrost=isNoFrost;
		this.garantia=garantia;
	}
	
	public Boolean isNoFrost() {
		return isNoFrost;
	}

	@Override
	public Integer getGarantia() {
		return garantia;
	}

}
