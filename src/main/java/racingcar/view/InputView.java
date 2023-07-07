package racingcar.view;

import racingcar.domain.TryCount;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static TryCount processTryCount() {
        try {
            return readTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return processTryCount();
        }
    }

    public static TryCount readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        return new TryCount(input);
    }

    public static List<CarName> processCarNames() {
        try {
            return readCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return processCarNames();
        }
    }

    public static List<CarName> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return split(input);
    }

    private static List<String> split(String input) {
        String[] carNames = input.split(",");
        if (carNames.length == 0)  {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 다시 입력해주세요");
        }
        return List.of(carNames);
    }
}
