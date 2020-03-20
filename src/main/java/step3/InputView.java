package step3;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private int carCount;
    private int moveCount;

    public InputView(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
    }

    public void inputCarInfoByUser() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        inputCarCount(carCount);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();
        inputMoveCount(moveCount);
    }

    public void inputCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void inputMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
