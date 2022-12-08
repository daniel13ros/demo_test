package com.daniel.demo_test.exceptions;

import lombok.Getter;

/**
 * Created by danielR on 08/12/2022
 */
@Getter
public enum ErrMsg {


    ID_NOT_FOUND("id not found");


    private String msg;

    ErrMsg(String msg) {
        this.msg = msg;
    }
}
