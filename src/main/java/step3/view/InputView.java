package step3.view;

import java.util.Scanner;

public class InputView {

    private static final String JOIN_RACING_CAR_INPUT_MESSAGE = "레이싱에 참여할 자동차는 몇대 인가요?";
    private static final String RACING_TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇회 인가요?";
    private static Scanner scan = new Scanner(System.in);

    public int inputRacingCarCount() {
        System.out.println(JOIN_RACING_CAR_INPUT_MESSAGE);
        int inputRacingCarNumber = scan.nextInt();
        validateInputNumber(inputRacingCarNumber);
        return inputRacingCarNumber;
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
