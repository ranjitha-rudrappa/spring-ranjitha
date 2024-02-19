package com.bt.ms.im.util;

public class BadRequestResponse {
    private int errorCode;
    private String errorMessage;

    // Constructors, getters, and setters

    public BadRequestResponse() {
        // Default constructor
    }

    public BadRequestResponse(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

