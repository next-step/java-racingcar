package racing.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import racing.domain.NumberOfRound;

public class InputView {
    private static final String QUERY_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUERY_NUMBER_OF_ROUND = "시도할 회수는 몇 회 인가요?";
    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputNameOfCars() {
        System.out.println(QUERY_NAME_OF_CARS);
        return Arrays.asList(scanner.nextLine().split(DELIMITER));
    }

    public static NumberOfRound inputNumberOfRound() {
        System.out.println(QUERY_NUMBER_OF_ROUND);
        while (true) {
            try {
                return NumberOfRound.of(scanner.nextInt());
            } catch (Exception e) {
                System.out.printf("%s 다시 입력해주세요." + System.lineSeparator(), e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
