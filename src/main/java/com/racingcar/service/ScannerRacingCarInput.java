package com.racingcar.service;

import com.racingcar.model.RacingCarGame;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ScannerRacingCarInput implements RacingCarInput {

    private static String NAME_OF_RACING_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String COUNT_OF_ATTEMPT_MESSAGE = "시도할 회수는 몇 회 인가요?";


    @Override
    public RacingCarGame inputRacingCarData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(NAME_OF_RACING_CAR_MESSAGE);
        String nameOfRacingCars = scanner.nextLine();
        List<String> racingCarNames = Arrays.asList(StringUtils.split(nameOfRacingCars, ","));

        System.out.println(COUNT_OF_ATTEMPT_MESSAGE);
        Integer countOfAttempt = scanner.nextInt();

        return new RacingCarGameFactory().racingGame(racingCarNames, countOfAttempt);
    }
}
