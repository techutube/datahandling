package com.data.handler.util;

import com.data.handler.enums.MaskingEnum;
import org.springframework.stereotype.Component;

@Component
public class MaskingClass {

    public String mask(String data, MaskingEnum maskType) {
        switch (maskType) {
            case PAN:
                return maskPAN(data);
            case AADHAAR:
                return maskAadhaar(data);
            case CREDIT_CARD:
                return maskCreditCard(data);
            default:
                return maskDefault(data);
        }
    }

    private String maskPAN(String pan) {
        if (pan != null && pan.length() == 10) {
            int visibleDigits = 4;
            String maskedChars = "X".repeat(pan.length() - visibleDigits);
            return maskedChars + pan.substring(pan.length() - visibleDigits);
        } else {
            System.out.println("Invalid PAN length");
            return pan;
        }
    }

    private String maskAadhaar(String aadhaar) {
        if (aadhaar != null && aadhaar.length() == 12) {
            int visibleDigits = 4;
            String maskedChars = "X".repeat(aadhaar.length() - visibleDigits);
            return maskedChars + aadhaar.substring(aadhaar.length() - visibleDigits);
        } else {
            System.out.println("Invalid Aadhaar length");
            return aadhaar;
        }
    }

    private String maskCreditCard(String creditCard) {
        if (creditCard != null && creditCard.length() >= 4) {
            int visibleDigits = Math.min(creditCard.length(), 4);
            String maskedDigits = "X".repeat(creditCard.length() - visibleDigits);
            return maskedDigits + creditCard.substring(creditCard.length() - visibleDigits);
        } else {
            System.out.println("Invalid Credit Card length");
            return creditCard;
        }
    }

    private String maskDefault(String input) {
        if (input != null && input.length() >= 4) {
            int visibleChars = 4;
            String maskedChars = "X".repeat(input.length() - visibleChars);
            return maskedChars + input.substring(input.length() - visibleChars);
        } else if (input != null) {
            return "X".repeat(input.length());
        } else {
            System.out.println("Invalid input length");
            return input;
        }
    }

}


