package org.lawyer.spring.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientListItemDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private AddressDTO address;
}
