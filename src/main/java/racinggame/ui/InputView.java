package racinggame.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String CARS_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> readCarNames() {
        System.out.println(CARS_NAME_QUESTION);
        String carNames = scanner.nextLine();
        return arrayToList(carNames.split(DELIMITER));
    }

    public static int readTryCount() {
        System.out.println(TRY_COUNT_QUESTION);
        return scanner.nextInt();
    }

    private static List<String> arrayToList(String[] array) {
        return Arrays.stream(array)
                .collect(Collectors.toList());
    }

}
