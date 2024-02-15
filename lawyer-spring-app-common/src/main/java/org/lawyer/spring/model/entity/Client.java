package org.lawyer.spring.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Client")
@Table(name = "t_client")
public class Client extends Person {
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;
}


