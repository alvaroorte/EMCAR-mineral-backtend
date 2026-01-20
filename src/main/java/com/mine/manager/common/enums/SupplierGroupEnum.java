package com.mine.manager.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mine.manager.exception.PropertyNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SupplierGroupEnum {

    CLIENT("Cliente"),
    PERSONAL("Personal");

    private final String value;

    @JsonCreator
    public static SupplierGroupEnum fromString(String text) {
        if (text == null || text.isBlank()) {
            return null;
        }
        try {
            return SupplierGroupEnum.valueOf(text.toUpperCase());
        } catch (IllegalArgumentException e) {
        }
        for (SupplierGroupEnum type : SupplierGroupEnum.values()) {
            if (type.getValue().equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new PropertyNotFoundException(text, "Grupo");
    }

    @JsonValue
    public String toValue() {
        return this.getValue();
    }
}
