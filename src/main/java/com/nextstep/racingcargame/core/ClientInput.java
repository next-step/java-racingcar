package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.view.ClientView.printSource;
import static java.util.Arrays.stream;

import java.util.Scanner;

public class ClientInput {

    private static final String HAS_NEGATIVE_MSG = "음수값으론 경기를 진행할 수 없습니다.";
    private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private final int numberOfCars;
    private final int numberOfTries;

    public ClientInput(int numberOfCars, int numberOfTries) {
        if (hasNegative(numberOfCars, numberOfTries)) {
            throw new IllegalArgumentException(HAS_NEGATIVE_MSG);
        }
        this.numberOfCars = numberOfCars;
        this.numberOfTries = numberOfTries;
    }

    public static ClientInput getClientInputByCarAndTryCounts() {
        Scanner scanner = new Scanner(System.in);

        printSource(CAR_QUESTION);
        int carCount = scanner.nextInt();

        printSource(TRY_QUESTION);
        int tryCount = scanner.nextInt();

        return new ClientInput(carCount, tryCount);
    }

    private boolean hasNegative(int... clientInputs) {
        return stream(clientInputs)
                .anyMatch(clientInput -> clientInput < 1);
    }

    public Cars createCarsByUserCarNumberInput() {
        return new Cars(this.numberOfCars);
    }

    public int getNumberOfTries() {
        return this.numberOfTries;
    }

    @Override
    public String toString() {
        return "ClientInput{" +
                "numberOfCars=" + numberOfCars +
                ", numberOfTries=" + numberOfTries +
                '}';
    }
}
