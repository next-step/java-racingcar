package step5.view;

import step5.exception.RacingGameInputException;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }


    public static int inputAttemptNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] carNamesList= carNamesToList(input);
        validateCarName(carNamesList);
        return carNamesList;
    }

    private static String[] carNamesToList(String input) {
        return input.split(",");
    }

    private static void validateCarName(String[] carNamesList) {
        for (String carName : carNamesList) {
            exceptionExceeds5Letters(carName);
        }
    }

    private static void exceptionExceeds5Letters(String carName) {
        if (carName.length() > 5) {
            throw new RacingGameInputException("5자 이하의 자동차 이름을 입력하세요");
        }
    }
}
