package step3.ui;

import java.util.List;
import java.util.Scanner;

public class Cui implements Ui{

    @Override
    public int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();
        System.out.println(carCount);
        return carCount;
    }

    @Override
    public int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int tryCount = scanner.nextInt();
        System.out.println(tryCount);
        return tryCount;
    }

    @Override
    public void showResult(List<String> histories) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (String history : histories) {
            System.out.println(history);
        }
    }
}
