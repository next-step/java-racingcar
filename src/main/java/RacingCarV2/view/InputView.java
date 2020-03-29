package RacingCarV2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String STAGE_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String MIN_CAR_COUNT_ERROR_MESSAGE = "최소 2개의 자동차가 있어야 합니다.";
    private static final String MIN_STAGE_COUNT_ERROR_MESSAGE = "최소 1번 이상 시도해야 합니다.";

    private static final String CAR_NAME_DELIMITER = ",";

    private Scanner scanner = new Scanner(System.in);


    private String[] splitInputName(String input) {
        return input.trim().split(CAR_NAME_DELIMITER);
    }

    private void validateName(String input) {
        if (!input.contains(CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException(MIN_CAR_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateStage(int stage) {
        if (!(stage > 0)) {
            throw new IllegalArgumentException(MIN_STAGE_COUNT_ERROR_MESSAGE);
        }
    }

    public List<String> getNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = scanner.nextLine();
        validateName(input);
        System.out.println(input);
        return Arrays.asList(splitInputName(input));
    }

    public int getStage() {
        System.out.println(STAGE_INPUT_MESSAGE);
        int stage = scanner.nextInt();
        validateStage(stage);
        System.out.println(stage);
        return stage;
    }

}
