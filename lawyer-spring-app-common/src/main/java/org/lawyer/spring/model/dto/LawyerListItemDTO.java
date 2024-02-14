package org.lawyer.spring.model.dto;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class LawyerListItemDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String specialization;
    private String consultationTitle;
}
