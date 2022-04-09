package step3.ui;

import java.util.List;
import java.util.Scanner;

public class Cui {

    public int scanCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();
        System.out.println(carCount);
        return carCount;
    }

    public int scanTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int tryCount = scanner.nextInt();
        System.out.println(tryCount);
        return tryCount;
    }

    public void printResult(List<String> histories) {
        System.out.println("\n실행 결과");
        for (String history : histories) {
            System.out.println(history);
        }
    }
}
