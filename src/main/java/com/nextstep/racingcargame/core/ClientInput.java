package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.view.ClientView.printSource;

import java.util.Scanner;

public class ClientInput {

    private static final String HAS_NEGATIVE_MSG = "시도 횟수는 1 이상의 숫자만 가능합니다.";
    private static final String CAR_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private final int numberOfTries;

    private final CarNameChunk carNameChunk;

    public ClientInput(String carNameClientInput, int numberOfTries) {
        if (!isPositive(numberOfTries)) {
            throw new IllegalArgumentException(HAS_NEGATIVE_MSG);
        }
        this.carNameChunk = new CarNameChunk(carNameClientInput);
        this.numberOfTries = numberOfTries;
    }

    public static ClientInput getClientInputByCarAndTryCounts() {
        Scanner scanner = new Scanner(System.in);

        printSource(CAR_QUESTION);
        String carNameClientInput = scanner.next();

        printSource(TRY_QUESTION);
        int tryCount = scanner.nextInt();

        return new ClientInput(carNameClientInput, tryCount);
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
