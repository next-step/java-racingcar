package com.racingcar.service;

import com.racingcar.model.Player;

import java.util.Scanner;

public class ScannerRacingCarPlayerAccessor implements RacingCarPlayerAccessor {

    @Override
    public Player accessRacingCarPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        Integer countOfRacingCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        Integer countOfAttempt = scanner.nextInt();

        return new Player(countOfRacingCar, countOfAttempt);
    }
}
