package com.daniel.demo_test.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by danielR on 08/12/2022
 */
@Data
@AllArgsConstructor
public class ErrorDetails {

    private final String key = "SG 151";
    private String value;
}
