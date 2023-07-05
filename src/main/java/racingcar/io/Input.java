package racingcar.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> processCarNames() {
        try {
            return readCarNames();
        } catch (CarNameInputException e) {
            System.out.println("자동차 이름의 길이가 5이하여야 합니다.");
            return processCarNames();
        }
    }

    public static int processTryCount() {
        try {
            return readTryCount();
        } catch (TryCountInputException e) {
            System.out.println("숫자만 입력받을 수 있습니다.");
            return processTryCount();
        }
    }

    private static int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        if (validateNumber(input)) {
            return Integer.parseInt(input);
        }
        throw new TryCountInputException();
    }

    public static boolean validateNumber(String number) {
        return number.matches(NUMBER_REGEX);
    }

    private static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return transferStringToList(input);
    }

    public static boolean validateCarNames(String[] carNames) {
        return Arrays.stream(carNames)
                .noneMatch(Input::validateCarName);
    }

    private static boolean validateCarName(String carName) {
        return (carName == null || carName.length() > 5);
    }

    public static List<String> transferStringToList(String input) {
        String[] carNames = input.split(",");
        if (validateCarNames(carNames)) {
            return List.of(carNames);
        }
        throw new CarNameInputException();
    }
}
