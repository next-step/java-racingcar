package racingcar;

import java.util.Scanner;

public class InputView {
    private final String QUERY_FOR_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private final String QUERY_FOR_NUMBER_OF_TURNS = "시도할 회수는 몇 회 인가요?";

    public int getNumberOfCars() {
        System.out.println(QUERY_FOR_NUMBER_OF_CARS);
        return getIntUserInput();
    }

    public int getNumberOfTurns() {
        System.out.println(QUERY_FOR_NUMBER_OF_TURNS);
        return getIntUserInput();
    }

    private int getIntUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            String value = scanner.nextLine();
            return Integer.parseInt(value);
        }
    }
}
