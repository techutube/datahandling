package com.data.handler.enums;

import lombok.Getter;

@Getter
public enum MaskingEnum {
    PAN("PAN"),
    AADHAAR("Aadhaar"),
    CREDIT_CARD("Credit card"),
    DEFAULT("Default");

    private final String description;
    MaskingEnum(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
