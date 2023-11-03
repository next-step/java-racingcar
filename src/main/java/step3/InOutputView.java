package step3;

import java.util.Scanner;

public class InOutputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int inputCarCount() {
        return scanner.nextInt();
    }

    public int inputMoveCount() {
        return scanner.nextInt();
    }

    public void outputCarPrint() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void outputMovePrint() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
