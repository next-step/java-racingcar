package racingcar.view;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 , 기준으로 구분)");
        return scanner.nextLine();
    }

    public static int getLaps() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
