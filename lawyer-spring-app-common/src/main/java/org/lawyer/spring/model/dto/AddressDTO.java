package org.lawyer.spring.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddressDTO {
    private Long id;
    private String country;
    private String state;
    private String place;
    private String street;
    private String houseNum;
    private String apartment;
}
