package com.bivgroup.ipr.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Map;

/**
 * Тип оплаты
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaymentType {

    CASH,

    NONCASH;

    @JsonCreator
    @SuppressWarnings("unchecked")
    public static PaymentType getEnumFromValue(Object value) {
        if (value instanceof String) {
            for (PaymentType paymentType : values()) {
                if (paymentType.toString().equals(value)) {
                    return paymentType;
                }
            }
        }
        if (value instanceof Integer) {
            for (PaymentType paymentType : values()) {
                if (Integer.valueOf(paymentType.ordinal()).equals(value)) {
                    return paymentType;
                }
            }
        }
        if (value instanceof Map) {
            Map<String, Object> objectMap = (Map<String, Object>) value;
            String name = String.valueOf(objectMap.get("paymentType"));
            return getEnumFromValue(name);
        }
        throw new IllegalArgumentException();
    }

    public String getPaymentType(){
        return this.name();
    }
}