package com.step3.model.car;

import java.util.Objects;

public class Name {
    private static final int CAR_NAME_LENGTH_BOUND = 5;

    private String name;

    public Name(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    private void validateCarName(String name) {
        if (name.length() > CAR_NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("자동차 이름 5자 이하 필수");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }
}
