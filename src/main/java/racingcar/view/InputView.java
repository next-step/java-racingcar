package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String NAME_SPLITTER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getTurn() {
        int turn;

        System.out.println("시도할 횟수는 몇 회인가요?");
        turn = readInt();
        System.out.println();

        return turn;
    }

    public static List<String> parseCarNames(final String carNames) {
        if (!carNames.contains(NAME_SPLITTER)) {
            throw new IllegalArgumentException("이름 구분자가 없거나 잘못되었습니다.");
        }

        return Arrays.stream(carNames.split(NAME_SPLITTER))
            .collect(Collectors.toList());
    }

    private static int readInt() {
        return scanner.nextInt();
    }

    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }
}
