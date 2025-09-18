package com.emazon.microservice_transaction.domain.constant;

public final class SuppliesBusinessRules {
    private SuppliesBusinessRules(){
    }
    public static final String NOTE_NOT_BLANK="The supply notes cannot be empty.";
    public static final String STOCK_NOT_NEGATIVE="The number of items cannot be negative and cannot be empty.";
    public static final String DATE_NOT_NULL="The supply entry date field cannot be left blank.";
    public static final String INVALID_FORMAT_DATE = "Invalid date format. Use the format dd/MM/yyyy.";
    }

