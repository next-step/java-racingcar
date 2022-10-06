package game.view;

import game.controller.dto.GameParam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_FOR_TRY_NUM = "시도할 횟수는 몇 회 인가요?";
    private static final String COMMA_SEPARATOR = ",";

    private InputView() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static GameParam getGameParam() {
        try(Scanner scanner = new Scanner(System.in)) {
            return new GameParam(inputCarNames(scanner), inputCountOfTry(scanner));
        }
    }

    private static int inputCountOfTry(Scanner scanner) {
        System.out.println(QUESTION_FOR_TRY_NUM);
        return inputNum(scanner);
    }

    private static List<String> inputCarNames(Scanner scanner) {
        System.out.println(QUESTION_FOR_CAR_NAMES);
        return Arrays.stream(inputString(scanner).split(COMMA_SEPARATOR))
                .collect(Collectors.toList());
    }

    private static int inputNum(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static String inputString(Scanner scanner) {
        return scanner.nextLine();
    }
}
