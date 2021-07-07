package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.excepciones.ProductoInexistente;
import ar.edu.unlam.pb2.excepciones.ProductoSinStock;

public class Supermercado {
	
	String nombre; // Nombre del supermercado
	private Set<Producto> productosExistentes; // Listado de productos que se comercializan
	private List<Producto> productosDisponibles; // Detalle de cada producto ingresado
	private Map<Integer, Venta> ventasRealizadas; // Listado de ventas realizadas (identificadas por el número de venta)
	Integer contadorDeVentas; // Identificador del número de venta
	
	public Supermercado(String nombre) {
		// Constructor de la clase
		this.nombre=nombre;
		productosExistentes = new HashSet<Producto>();
		productosDisponibles = new ArrayList<Producto>();
		ventasRealizadas = new HashMap<Integer, Venta>();
	}

	public void ingresarProducto(Producto nuevo) {
		// Ingresa un nuevo producto
		productosDisponibles.add(nuevo);
		/*
		for (Producto productoIngresado : productosExistentes) {
			if(productoIngresado.getCodigo().equals(nuevo.getCodigo())) {
				productosExistentes.add(nuevo);
			}else {
				productosDisponibles.add(nuevo);
			}
		}
		*/
	}

	public Set<Producto> getOfertaDeProductos() {
		// Devuelve el conjunto de productos que se comercializan
		Set<Producto> ofertaProductos = new HashSet<>();
		ofertaProductos.addAll(productosDisponibles);
		return ofertaProductos;
	}
	
	public Integer getStock(Integer codigo) {
		// Devuelve la cantidad de unidades de un producto determinado
		Integer stockProducto=0;		
		for (Producto productoBuscado : productosDisponibles) {
			if(productoBuscado.getCodigo().equals(codigo)){
				stockProducto++;
			}
		}
		return stockProducto;
	}
	
	private Boolean productoExiste(Integer codigoDeProducto) throws ProductoInexistente{
		// Verifica si un producto existe
		for (Producto productoAVerificar : productosExistentes) {
			if(productoAVerificar.getCodigo().equals(codigoDeProducto)) {
				return true;
			}else {
				throw new ProductoInexistente();
			}
		}
		return false;
	}
	
	private Producto getProductoPorCodigo(Integer codigoDeProducto) throws ProductoSinStock {
		// Busca la disponibilidad de un producto
		for (Producto productoBuscado : productosDisponibles) {
			if(productoBuscado.getCodigo().equals(codigoDeProducto)) {
				return productoBuscado;
			}else {
				throw new ProductoSinStock();
			}
		}
		return null;
	}
	
	public Integer registrarNuevaVenta(Integer dniDelComprador, String nombreDelComprador) {
		// Registra una nueva venta
		ventasRealizadas.put(++contadorDeVentas, new Venta(dniDelComprador, nombreDelComprador));
		return contadorDeVentas;
	}
	
	public Venta getVenta(Integer numeroDeVenta) {
		// Devuelve una venta en función de su número identificatorio
		return ventasRealizadas.get(numeroDeVenta);
	}

	public void agregarAlCarrito(Integer numeroDeVenta, Integer codigoDeProducto) throws ProductoSinStock, ProductoInexistente {
		// Incorpora al carrito de compras de la venta identificada por el "numeroDeVenta", el producto identificado por el "codigoDeProducto"
		Producto productoAgregado = getProductoPorCodigo(codigoDeProducto);
		
		if(getProductoPorCodigo(codigoDeProducto)==null) {
			throw new ProductoSinStock();
		}
		
		if(productoExiste(codigoDeProducto)==false) {
			throw new ProductoInexistente();
		}
		
		if(productoExiste(codigoDeProducto)==true && getProductoPorCodigo(codigoDeProducto) != null) {
			getVenta(numeroDeVenta).agregarProducto(productoAgregado);
		}		
		
	}
	

}
