package com.edu.ms_product.exceptions;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private Date timestamp;
    private Object message;
    private String description;
}
