package racingcar.view;

import java.util.Scanner;

public class StartView {
    static final String INPUT_CAR_NUM_INSTRUCTION
            = "레이스에 참가하는 차량의 수를 입력하세요 : ";
    static final String INPUT_ROUND_NUM_INSTRUCTION
            = "진행할 레이스의 라운드 수를 입력하세요 : ";

    static int inputCarNum() {
        System.out.print(INPUT_CAR_NUM_INSTRUCTION);
        return new Scanner(System.in).nextInt();
    }

    static int inputRoundNum() {
        System.out.print(INPUT_ROUND_NUM_INSTRUCTION);
        return new Scanner(System.in).nextInt();
    }
}
