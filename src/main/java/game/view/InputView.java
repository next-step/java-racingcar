package game.view;

import game.controller.dto.GameParam;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_FOR_CAR_NUM = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_FOR_TRY_NUM = "시도할 횟수는 몇 회 인가요?";

    private InputView() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static GameParam getGameParam() {
        try(Scanner scanner = new Scanner(System.in)) {
            return new GameParam(inputCountOfCar(scanner), inputCountOfTry(scanner));
        }
    }

    private static int inputCountOfCar(Scanner scanner) {
        System.out.println(QUESTION_FOR_CAR_NUM);
        return inputNum(scanner);
    }

    private static int inputCountOfTry(Scanner scanner) {
        System.out.println(QUESTION_FOR_TRY_NUM);
        return inputNum(scanner);
    }

    private static int inputNum(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
