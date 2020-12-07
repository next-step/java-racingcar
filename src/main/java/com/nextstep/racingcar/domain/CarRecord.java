package com.nextstep.racingcar.domain;

public class CarRecord {
    private String name;
    private int position;

    public CarRecord(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
