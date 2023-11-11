package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scan = new Scanner(System.in);

    private static final String JOIN_RACING_CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분합니다).";
    private static final String RACING_TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇회 인가요?";


    public String inputRacingCarNames() {
        System.out.println(JOIN_RACING_CAR_INPUT_MESSAGE);
        String inputRacingCarNames = scan.nextLine();
        validateInputRacingCarNames(inputRacingCarNames);
        return inputRacingCarNames;
    }

    private void validateInputRacingCarNames(String inputRacingCarNames) {
        if (inputRacingCarNames == null || inputRacingCarNames.isEmpty()) {
            throw new IllegalArgumentException("최소 한 개 이상의 자동차 이름을 입력해야 합니다.");
        }
    }

    public int inputTryCount() {
        System.out.println(RACING_TRY_COUNT_INPUT_MESSAGE);
        int inputTryCount = scan.nextInt();
        validateInputNumber(inputTryCount);
        return inputTryCount;
    }

    private void validateInputNumber(final int inputNumber) {
        if (inputNumber <= 0) {
            throw new IllegalArgumentException("입력하신 값이 올바르지 않습니다. 다시 확인해주세요");
        }
    }

}
