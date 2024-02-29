package org.lawyer.spring.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ClientDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private AddressDTO address;
    private List<OrderDTO> orders;
}
