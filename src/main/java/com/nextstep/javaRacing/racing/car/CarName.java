package com.nextstep.javaRacing.racing.car;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if(name.length()>5) {
            throw new IllegalArgumentException("자동차 이름은 " + NAME_MAX_LENGTH + "글자를 초과할 수 없습니다 : " + name);
        }
    }

    public String getName() {
        return this.name;
    }
}
