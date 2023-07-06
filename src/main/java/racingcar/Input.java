package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    private final static Scanner scanner = new Scanner(System.in);

    public static int processTryCount() {
        try {
            return readTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println("숫자만 입력받을 수 있습니다.");
            return processTryCount();
        }
    }

    private static int readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        if (isValidNumber(input)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException();
    }

    public static boolean isValidNumber(String number) {
        return number.matches("[0-9]+");
    }

    public static List<CarName> processCarNames() {
        try {
            return readCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println("자동차 이름의 길이가 5 이하여야 합니다.");
            return processCarNames();
        }
    }

    private static List<CarName> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return split(input);
    }

    public static List<CarName> split(String input) {
        String[] carNames = input.split(",");
        if (carNames.length == 0)  {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(carNames)
                .map(CarName::new)
                .collect(Collectors.toList());
    }
}
