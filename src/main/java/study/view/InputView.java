package study.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() { //인스턴스화 방지
    }

    public static int setNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int setNumberOfMoves() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
