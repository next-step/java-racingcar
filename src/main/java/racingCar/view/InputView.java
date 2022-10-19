package racingCar.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private int carCnt;
    private String carNames;
    private int moveCnt;

    public int carCnt() {
        return carCnt;
    }

    public String carNames() {
        return carNames;
    }

    public int moveCnt() {
        return moveCnt;
    }

    public void severalCars(int carCnt) {
        this.carCnt = carCnt;
    }

    private void scanCarCnt() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCnt = scanner.nextInt();
    }

    private void scanCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.next();
    }

    private void scanMoveCnt() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        moveCnt = scanner.nextInt();
    }

    public void scan() {
        scanCarCnt();
        scanMoveCnt();
    }

    public void scanWithNames() {
        scanCarNames();
        scanMoveCnt();
    }
}
