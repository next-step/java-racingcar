package step3;

import java.util.Scanner;

public class InputView {

    private static final String JOIN_RACING_CAR_INPUT_MESSAGE = "레이싱에 참여할 자동차는 몇대 인가요?";
    private static Scanner scan = new Scanner(System.in);

    public int inputRacingCarCount() {
        System.out.println(JOIN_RACING_CAR_INPUT_MESSAGE);
        int racingCarCount = scan.nextInt();
        validateInputRacingCarCount(racingCarCount);
        return racingCarCount;
    }

    private void validateInputRacingCarCount(int racingCarCount) {
        if (racingCarCount <= 0) {
            throw new IllegalArgumentException("입력하신 값이 올바르지 않습니다. 다시 확인해주세요");
        }
    }

}
