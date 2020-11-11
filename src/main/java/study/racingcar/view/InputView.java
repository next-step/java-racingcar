package study.racingcar.view;

import study.racingcar.domain.GameConfiguration;
import study.racingcar.domain.car.OldEngine;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static GameConfiguration initGameWithOldEngine() {

        System.out.println("Enter car names. Car names are splitted by (,).");

        String carNamesWithComma = scanner.nextLine();

        System.out.println("How much times do you attempts?");

        int numberOfAttempts = scanner.nextInt();

        return new GameConfiguration(carNamesWithComma, numberOfAttempts, OldEngine.getInstance());
    }

}
