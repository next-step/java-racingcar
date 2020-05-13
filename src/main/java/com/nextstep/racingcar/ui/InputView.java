package com.nextstep.racingcar.ui;

import java.util.Scanner;

public class InputView {
    private int carNumber;
    private int roundNumber;

    public InputView(int carNumber, int roundNumber) {
        this.carNumber = carNumber;
        this.roundNumber = roundNumber;
    }

    public static InputView create(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요");
        int roundNumber = scanner.nextInt();

        return new InputView(carNumber, roundNumber);
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
