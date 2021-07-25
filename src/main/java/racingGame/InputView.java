package racingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_REPEAT_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static final String CAR_NAMES_DELIMITER = ",";

    private final static Scanner scanner = new Scanner(System.in);

    public static List<Car> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return splitStringWithCommaToList(scanner.nextLine());
    }

    public static int inputRepeatCount() {
        System.out.println(INPUT_REPEAT_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<Car> splitStringWithCommaToList(String input) {
        return Arrays.stream(input.split(CAR_NAMES_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
