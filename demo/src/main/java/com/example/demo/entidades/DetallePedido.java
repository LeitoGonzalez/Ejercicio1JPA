package com.example.demo.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="DetallePedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class DetallePedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int cantidad;
    private double subtotal;

    @ManyToOne(fetch = FetchType.EAGER)
    private Producto producto;
}
