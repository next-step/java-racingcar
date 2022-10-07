package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);
    private static final String NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private static final String DELIMITER = ",";

    public static List<String> nameOfCars() {
        System.out.println(NAME_OF_CARS);
        String names = sc.next();
        String[] name = names.split(DELIMITER);
        return Arrays.asList(name);
    }

    public static int numberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS);
        return sc.nextInt();
    }
}
