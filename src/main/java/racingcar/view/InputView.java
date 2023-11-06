package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<String> inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String input = scanner.next();

        return Arrays.asList(input.split(","));
    }

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
