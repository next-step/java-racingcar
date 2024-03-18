package racinggame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String TRY_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    public static final String DELIMITER_COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarsName() {
        System.out.println(CAR_NAME_QUESTION);
        String carsName = scanner.nextLine();
        return splitCarsName(carsName);
    }

    private List<String> splitCarsName(String inputNames) {
        return Arrays.stream(inputNames.split(DELIMITER_COMMA))
                .collect(Collectors.toList());
    }

    public int inputTryCount() {
        System.out.println(TRY_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
