package com.bt.ms.im.error;

import com.bt.ms.im.util.BadRequestResponse;

public class BadRequestException1 extends RuntimeException {
    private BadRequestResponse badRequestResponse;

    public BadRequestException1(BadRequestResponse badRequestResponse) {
        super(badRequestResponse.getErrorMessage()); // Set the error message as the exception message
        this.badRequestResponse = badRequestResponse;
    }

    public BadRequestResponse getBadRequestResponse() {
        return badRequestResponse;
    }
}
