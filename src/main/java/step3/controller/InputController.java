package step3.controller;

import step3.RacingSpec;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputController {

    private static final String CAR_COUNT_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String UESR_SPLIT_DELIMITER = ",";

    public static RacingSpec enterInput() {
        List<String> users = enterRacingUser();
        Integer lap = enterRacingLap();
        return new RacingSpec(users, lap);
    }

    private static List<String> enterRacingUser() {
        System.out.println(CAR_COUNT_QUESTION);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        List<String> strings = Arrays.asList(input.split(UESR_SPLIT_DELIMITER));
        return strings
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static Integer enterRacingLap() {
        System.out.println(MOVE_COUNT_QUESTION);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
