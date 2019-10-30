package racing;

import java.util.Scanner;

public class RacingInput {
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도 할 회수는 몇 회 인가요?";
    private static final String RACER_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private Scanner scanner;

    public RacingInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        int tryCountInput = scanner.nextInt();

        try {
            checkTryCountInput(tryCountInput);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputTryCount();
        }

        return tryCountInput;
    }

    private void checkTryCountInput(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("시도 할 회수는 0 이상이어야 합니다.");
        }
    }

    public String inputRacerNames() {
        System.out.println(RACER_NAMES_INPUT_MESSAGE);
        String racerNames = scanner.nextLine();

        try {
            checkRacerNamesInput(racerNames);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputRacerNames();
        }

        return racerNames;
    }

    private void checkRacerNamesInput(String racerNames) {
        if (StringUtils.isBlank(racerNames)) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
    }
}
