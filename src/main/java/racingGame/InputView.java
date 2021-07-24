package racingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_REPEAT_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return splitStringWithCommaToList(scanner.nextLine());
    }

    public static int inputRepeatCount() {
        System.out.println(INPUT_REPEAT_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<String> splitStringWithCommaToList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}
