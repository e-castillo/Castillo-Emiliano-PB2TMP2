package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Venta {

	private Integer dniDelComprador;
	private String nombreDelComprador;
	private Double importe;
	Set<Producto> productosEnCarrito;
	
	public Venta(Integer dniDelComprador, String nombreDelComprador) {
		this.dniDelComprador=dniDelComprador;
		this.nombreDelComprador=nombreDelComprador;
		this.importe=0.0;
		productosEnCarrito = new HashSet<Producto>();
	}

	public String getNombreDelComprador() {
		return nombreDelComprador;
	}

	public Integer getDniDelComprador() {
		return dniDelComprador;
	}
	
	public Boolean agregarProducto(Producto nuevoProducto) {
		productosEnCarrito.add(nuevoProducto);
		return true;
	}

	public Double getImporte() {
		Double precioTotal=0.0;
		for (Producto producto : productosEnCarrito) {
			precioTotal+=producto.getPrecio();
		}
		return precioTotal;
	}
	
	
}
