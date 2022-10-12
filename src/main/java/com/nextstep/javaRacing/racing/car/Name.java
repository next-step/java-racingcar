package com.nextstep.javaRacing.racing.car;

public class Name {

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if(name==null || name.length()<NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("이름은 " + NAME_MIN_LENGTH + "글자 이상이어야 합니다");
        }
        if(name.length()>NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 " + NAME_MAX_LENGTH + "글자를 초과할 수 없습니다");
        }
    }

    public String getName() {
        return this.name;
    }
}
