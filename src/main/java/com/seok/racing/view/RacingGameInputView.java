package com.seok.racing.view;

import com.seok.racing.domain.Racers;
import com.seok.racing.domain.Trials;

import java.util.Scanner;

public class RacingGameInputView {

    private static final String NAMES_OF_CARS_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_ATTEMPTS_MSG = "시도할 횟수는 몇 회 인가요 ?";
    private static final Scanner scanner = new Scanner(System.in);

    public static Racers getRacers() {
        System.out.println(NAMES_OF_CARS_MSG);
        return new Racers(scanner.nextLine());
    }

    public static Trials getTrials() {
        System.out.println(NUMBER_OF_ATTEMPTS_MSG);
        return new Trials(scanner.nextInt());
    }

}
