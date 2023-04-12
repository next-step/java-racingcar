package com.nextstep.racingcargame.core;

public class CarNameChunk {

    private static final String CAR_NAME_SEPARATOR = ",";

    private final String carNameChunk;

    public CarNameChunk(String carNameChunk) {
        this.carNameChunk = carNameChunk;
    }

    public String[] carNames() {
        return this.carNameChunk.split(CAR_NAME_SEPARATOR);
    }

}
