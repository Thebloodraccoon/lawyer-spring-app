package org.lawyer.spring.model.dto;


import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class ServiceDTO {
    private Long id;
    private String type;
    private String name;
    private LocalDate date;
    private double cost;
    private ClientDTO client;
    private LawyerDTO lawyer;
}