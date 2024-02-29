package org.lawyer.spring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity(name = "Address")
@Table(name = "t_address")
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String state;
    private String place;
    private String street;
    @Column(name = "house_num")
    private String houseNum;
    private String apartment;
}