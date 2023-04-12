package step3;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static step3.Car.*;

public class RacingCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇대인가요");
        int carCount = scanner.nextInt();
        validatePositive(carCount);

        Map<Integer, AtomicInteger> cars = generateCars(carCount);

        System.out.println("시도할 회수는 몇 회인가요");
        int period = scanner.nextInt();
        validatePositive(period);

        ResultView.startUI();
        iteratePeriod(period, cars);

    }
}
