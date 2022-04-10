package racing.ui;

import java.util.Scanner;

import racing.domain.NumberOfCars;
import racing.domain.NumberOfRound;

public class InputView {
    final static String QUERY_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    final static String QUERY_NUMBER_OF_ROUND = "자동차 대수는 몇 대 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static NumberOfCars inputNumberOfCars() {
        System.out.println(QUERY_NUMBER_OF_CARS);
        while (true) {
            try {
                return new NumberOfCars(scanner.nextInt());
            } catch (Exception e) {
                System.out.printf("%s 다시 입력해주세요." + System.lineSeparator(), e.getMessage());
                scanner.nextLine();
            }
        }
    }

    public static NumberOfRound inputNumberOfRound() {
        System.out.println(QUERY_NUMBER_OF_ROUND);
        while (true) {
            try {
                return new NumberOfRound(scanner.nextInt());
            } catch (Exception e) {
                System.out.printf("%s 다시 입력해주세요." + System.lineSeparator(), e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
