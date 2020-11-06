package study.racingcar.view;

import study.racingcar.GameConfiguration;
import study.racingcar.car.OldEngine;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static GameConfiguration initGameWithOldEngine() {

        System.out.println("how many cars do you need?");

        int numberOfCars = scanner.nextInt();

        System.out.println("How much times do you attemps?");

        int numberOfAttempts = scanner.nextInt();

        return new GameConfiguration(numberOfCars, numberOfAttempts, OldEngine.getInstance());
    }
}
