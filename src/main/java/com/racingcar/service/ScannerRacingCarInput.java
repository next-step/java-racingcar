package com.racingcar.service;

import com.racingcar.model.RacingCarGame;

import java.util.Scanner;

public class ScannerRacingCarInput implements RacingCarInput {

    private static String COUNT_OF_RACING_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static String COUNT_OF_ATTEMPT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    @Override
    public RacingCarGame inputRacingCarData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(COUNT_OF_RACING_CAR_MESSAGE);
        Integer countOfRacingCar = scanner.nextInt();

        System.out.println(COUNT_OF_ATTEMPT_MESSAGE);
        Integer countOfAttempt = scanner.nextInt();

        return new RacingCarGameFactory().racingGame(countOfRacingCar, countOfAttempt);
    }
}
