package com.step3.model.car;

public class CarId {
    private String name;

    public CarId(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 5자 이하 필수");
        }
    }
}
