package racingCar;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private int carCnt;
    private int moveCnt;

    public int carCnt() {
        return carCnt;
    }

    public int moveCnt() {
        return moveCnt;
    }

    private void scanCarCnt() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCnt = scanner.nextInt();
    }

    private void scanMoveCnt() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        moveCnt = scanner.nextInt();
    }

    public void scan() {
        scanCarCnt();
        scanMoveCnt();
    }
}
