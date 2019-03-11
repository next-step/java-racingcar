package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못 입력하셨습니다.");
            return 0;
        }
    }

    public int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못 입력하셨습니다.");
            return 0;
        }
    }
}
