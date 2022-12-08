package com.daniel.demo_test.exceptions;

/**
 * Created by danielR on 08/12/2022
 */
public class SchoolCostumeException extends Exception {
    public SchoolCostumeException(ErrMsg errMsg) {
        super(errMsg.getMsg());
    }
}
