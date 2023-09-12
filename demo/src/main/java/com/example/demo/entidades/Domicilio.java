package com.example.demo.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="Domicilio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class Domicilio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String calle;
    private String numero;
    private String localidad;
}