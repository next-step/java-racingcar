package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static int inputCarCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임에서 진행할 자동차의 수 : ");

        return scanner.nextInt();
    }

    public static int inputMoveCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차의 이동 횟수(게임 횟수) : ");

        return scanner.nextInt();
    }
}
