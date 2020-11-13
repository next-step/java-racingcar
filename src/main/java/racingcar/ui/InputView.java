package racingcar.ui;

import racingcar.domain.utils.Number;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private static final int ZERO = 0;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String findRacingCarNameList() {
        System.out.println("step4 자동차 경주");
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int getRepeatCount() {
        System.out.println("반복할 회수를 입력하세요. (1 이상)");
        int repeatCount = scanner.nextInt();
        if (repeatCount < ZERO) {
            throw new IllegalArgumentException("1 이상의 숫자가 필요합니다.");
        }
        return repeatCount;
    }
}
