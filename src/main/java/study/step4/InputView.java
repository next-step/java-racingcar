package study.step4;

import java.util.Scanner;

public class InputView {

    private String carList;
    private int tryCount;

    public void startMsg() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carList = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryCount = scanner.nextInt();
        System.out.println();
    }

    public String getCarList() {
        return carList;
    }

    public int getTryCount() {
        return tryCount;
    }
}
