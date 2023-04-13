package com.nextstep.racingcargame.core;

public class ClientResponse {

    private static final String HAS_NEGATIVE_MSG = "시도 횟수는 1 이상의 숫자만 가능합니다.";
    private final int numberOfTries;

    private final CarNameChunk carNameChunk;

    public ClientResponse(String carNameClientInput, int numberOfTries) {
        if (!isPositive(numberOfTries)) {
            throw new IllegalArgumentException(HAS_NEGATIVE_MSG);
        }
        this.carNameChunk = new CarNameChunk(carNameClientInput);
        this.numberOfTries = numberOfTries;
    }

    private boolean isPositive(int clientInput) {
        return clientInput > 0;
    }

    public Cars createCarsByUserCarNumberInput() {
        return new Cars(this.carNameChunk);
    }

    public int getNumberOfTries() {
        return this.numberOfTries;
    }

}
