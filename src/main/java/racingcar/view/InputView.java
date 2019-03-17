package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputCarNames() {
        System.out.println("경주할 차 이름을 정해주세요! ");
        return scanner.nextLine().split(",");
    }

    public static int inputRound() {
        System.out.println("몇 라운드 실행 할거에요?");
        return scanner.nextInt();
    }

}
