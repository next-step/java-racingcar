package com.nextstep.racingcargame.core;

import static java.util.Arrays.stream;

public class CarNameChunk {

    private static final String CAR_NAME_SEPARATOR = ",";

    private static final String CAR_EMPTY_VALUE_MSG = "차 이름이 임력되지 않았습니다.";

    private static final String CAR_NAME_MORE_THAN_FIVE_CHARACTER = "자동차 이름은 5자를 초과할 수 없습니다.";

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carNameChunk;

    public CarNameChunk(String carNameChunk) {
        if(isCarNameEmpty(carNameChunk)) {
            throw new IllegalArgumentException(CAR_EMPTY_VALUE_MSG);
        }
        if(hasCarNameMoreThanFiveCharacter(carNameChunk)) {
            throw new IllegalArgumentException(CAR_NAME_MORE_THAN_FIVE_CHARACTER);
        }
        this.carNameChunk = carNameChunk;
    }

    public String[] carNames() {
        return this.carNameChunk.split(CAR_NAME_SEPARATOR);
    }

    private boolean isCarNameEmpty(String carNameChunk) {
        return carNameChunk == null || carNameChunk.isEmpty();
    }

    private boolean hasCarNameMoreThanFiveCharacter(String carNameChunk) {
        return stream(carNameChunk.split(CAR_NAME_SEPARATOR))
                .anyMatch(carName -> carName.length() > CAR_NAME_MAX_LENGTH);
    }
}
