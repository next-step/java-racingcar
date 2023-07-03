package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private final static Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return transferStringToList(input);
    }

    public static boolean validateCarNames(String[] carNames) {
        long count = Arrays.stream(carNames).filter(Input::validateCarName).count();
        return count == 0;
    }

    private static boolean validateCarName(String carName) {
        return (carName == null || carName.length() > 5);
    }

    public static List<String> transferStringToList(String input) {
        String[] carNames = input.split(",");
        if (validateCarNames(carNames)) {
            return List.of(carNames);
        }
        throw new IllegalArgumentException();
    }
}
