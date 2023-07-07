package racingcar.app.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

    private static final String CAR_NAME_SEPARATE_EXPRESSION = ",";

    private ConsoleInput() {
    }

    public static ConsoleInput getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public List<String> inputCarNames() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            return Arrays.asList(scanner.next().split(CAR_NAME_SEPARATE_EXPRESSION));
        }
    }

    public int inputRound() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("시도할 회수는 몇회인가요?");
            return scanner.nextInt();
        }
    }

    private static final class SingletonHelper {

        private static final ConsoleInput INSTANCE = new ConsoleInput();

    }

}
