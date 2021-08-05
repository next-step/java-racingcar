package racingcar.view;

import java.util.Scanner;

public class StartView {
    static final String INPUT_CAR_NUM_INSTRUCTION
            = "레이스에 참가하는 차량의 수를 입력하세요 : ";
    static final String INPUT_ROUND_NUM_INSTRUCTION
            = "진행할 레이스의 라운드 수를 입력하세요 : ";
    static final int MIN_CAR_NUM = 1;
    static final int MIN_ROUND_NUM = 1;

    static boolean isValidCarNum(int input) {
        return input >= MIN_CAR_NUM;
    }

    static boolean isValidRoundNum(int input) {
        return input >= MIN_ROUND_NUM;
    }

    public static int inputCarNum() {
        int input;

        System.out.print(INPUT_CAR_NUM_INSTRUCTION);

        do {
            input = new Scanner(System.in).nextInt();
        } while (!isValidCarNum(input));

        return input;
    }

    public static int inputRoundNum() {
        int input;

        System.out.print(INPUT_ROUND_NUM_INSTRUCTION);

        do {
            input = new Scanner(System.in).nextInt();
        } while (!isValidRoundNum(input));

        return input;
    }
}
