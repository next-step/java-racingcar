package racingcar.view;

import java.util.Scanner;

public class InputView {
    public static final String DELIMITER = ",";

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }


    public String[] readCar() {
        System.out.println(CAR_NAME_MESSAGE);
        return scanner.nextLine().split(DELIMITER);
    }

    public Integer readRace() {
        System.out.println(RACE_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}