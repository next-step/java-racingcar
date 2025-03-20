package racinggame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racinggame.exception.NotPositiveNumberException;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return Arrays.asList(input.split("\\s*,\\s*"));
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int input = Integer.parseInt(scanner.nextLine());
        if (input < 0) {
            throw new NotPositiveNumberException();
        }
        return input;
    }
}
