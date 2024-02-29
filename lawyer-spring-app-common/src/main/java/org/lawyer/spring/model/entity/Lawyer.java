package org.lawyer.spring.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Entity(name = "Lawyer")
@Table(name = "t_lawyer")
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String specialization;
    @Column(name = "consultation_title")
    private String consultationTitle;


    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "lawyer")
    private List<Order> orders;
}
