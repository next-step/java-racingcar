package com.nextstep.racingcargame.core;

import static java.util.Arrays.stream;

public class CarNameChunk {

    private static final String CAR_NAME_SEPARATOR = ",";

    private static final String CAR_EMPTY_VALUE_MSG = "차 이름이 임력되지 않았습니다.";

    private final String carNameChunk;

    public CarNameChunk(String carNameChunk) {
        if (isCarNameEmpty(carNameChunk)) {
            throw new IllegalArgumentException(CAR_EMPTY_VALUE_MSG);
        }
        this.carNameChunk = carNameChunk;
    }

    public String[] carNames() {
        return this.carNameChunk.split(CAR_NAME_SEPARATOR);
    }

    private boolean isCarNameEmpty(String carNameChunk) {
        return carNameChunk == null || carNameChunk.isEmpty();
    }

}
