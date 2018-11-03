package racinggame;

import java.util.Scanner;

public class InputView {

    public static int inputCountCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCnt = scanner.nextInt();
        return carCnt;
    }

    public static int inputTryCnt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int tryCnt = scanner.nextInt();
        return tryCnt;
    }
}
