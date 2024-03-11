package carRacing.view;

import java.util.Scanner;

public class InputView {

    private int carCount;
    private int moveCount;

    public InputView() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        moveCount = scanner.nextInt();
        scanner.close();
    }

    public int getCarCount() {
        System.out.println("carCount = " + carCount);
        return carCount;
    }

    public int getMoveCount() {
        System.out.println("moveCount = " + moveCount);
        return moveCount;
    }
}
