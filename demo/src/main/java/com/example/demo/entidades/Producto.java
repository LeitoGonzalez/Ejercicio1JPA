package com.example.demo.entidades;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String receta;

}
