package com.example.demo;

import com.example.demo.entidades.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class DemoApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		System.out.println("Estoy funcionando jej");
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository1){

		return args -> {
			System.out.println("Esto esta corriendo en un bean ;)");

			//Cliente
			Cliente cliente1 = new Cliente();

			cliente1.setNombre("Leo");
			cliente1.setApellido("Gonzalez");
			cliente1.setTelefono("+542615278353");



			//Domicilio
			Domicilio domicilio1 = new Domicilio();
			domicilio1.setCalle("Calle 123");
			domicilio1.setNumero("123");
			domicilio1.setLocalidad("Godoy cruz");

			cliente1.addDomicilio(domicilio1);

			Domicilio domicilio2 = new Domicilio();

			domicilio2.setCalle("Calle 321");
			domicilio2.setNumero("321");
			domicilio2.setLocalidad("Cruz Godoy");

			cliente1.addDomicilio(domicilio2);

			//Pedido
			Pedido pedido1 = new Pedido();

			LocalDate fechaEjemplo = LocalDate.of(2023, 9, 12);

			pedido1.setEstado("Iniciado");
			pedido1.setFecha(LocalDate.of(2023, 9, 12));
			pedido1.setTipoEnvio("Delivery");
			pedido1.setTotal(900);

			cliente1.addPedido(pedido1);

			//Factura
			Factura factura1 = new Factura();

			factura1.setNumero(1);
			factura1.setFecha(LocalDate.of(2023, 9, 12));
			factura1.setFormaDePago("MP");
			factura1.setTotal(8530);
			factura1.setDescuento(8530 * 0.25);

			pedido1.setFactura(factura1);

			//DetallePedido
			DetallePedido detallePedido = new DetallePedido();

			detallePedido.setCantidad(5);
			detallePedido.setSubtotal(50.0);

			pedido1.addDetallePedido(detallePedido);

			DetallePedido detallePedido1 = new DetallePedido();

			detallePedido1.setCantidad(5);
			detallePedido1.setSubtotal(25.0);

			pedido1.addDetallePedido(detallePedido1);

			//Producto
			Producto producto = new Producto();

			producto.setTipo("Manufacturado");
			producto.setTiempoEstimadoCocina(25);
			producto.setDenominacion("Hamburguesa Primavera");
			producto.setPrecioVenta(1000.50);
			producto.setPrecioCompra(500);
			producto.setStockActual(50);
			producto.setStockMinimo(20);
			producto.setUnidadMedida("Unidades");
			producto.setReceta("Pan, lechuga, huevo, tomate, rucula, queso, carne");

			detallePedido.setProducto(producto);

			detallePedido1.setProducto(producto);

			//Rubro
			Rubro rubro = new Rubro();

			rubro.setDenominacion("Hamburguesas");
			rubro.addProducto(producto);

			productoRepository.save(producto);
			rubroRepository.save(rubro);
			facturaRepository.save(factura1);
			pedidoRepository.save(pedido1);
			clienteRepository.save(cliente1);
		};

	}

}
