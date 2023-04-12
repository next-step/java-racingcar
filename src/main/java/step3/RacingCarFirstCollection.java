package step3;

import java.util.Scanner;

public class RacingCarFirstCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇대인가요");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회인가요");
        int period = scanner.nextInt();

        Cars car = Cars.of(carCount, period);

        ResultView.startUI();
        car.iteratePeriod();
    }
}
