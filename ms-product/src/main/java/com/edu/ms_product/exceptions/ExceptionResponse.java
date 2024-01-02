package com.edu.ms_product.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String description;
}
