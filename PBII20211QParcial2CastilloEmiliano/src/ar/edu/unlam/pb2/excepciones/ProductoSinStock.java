package ar.edu.unlam.pb2.excepciones;

public class ProductoSinStock extends Exception {

	public ProductoSinStock() {
		super("No hay stock del producto");
	}
	
}
