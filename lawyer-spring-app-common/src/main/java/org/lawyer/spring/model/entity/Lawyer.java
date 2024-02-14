package org.lawyer.spring.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Lawyer")
@Table(name = "t_lawyer")
public class Lawyer extends Person {
    private String specialization;
    private String consultationTitle;

    @OneToMany(mappedBy = "lawyer")
    private List<Service> services;
}
