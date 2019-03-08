package racingcar;

import java.util.Scanner;

public class RacingGame {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();
        System.out.println();

        start(numberOfCar, tryCount);
    }

    private void start(int numberOfCar, int tryCount) {
        System.out.println("실행 결과\n");
        Car[] cars = carSetUp(numberOfCar);

        for (int i = 0; i < tryCount; i++) {
            run(cars);
            showMovedDistance(cars);
            System.out.println();
        }
    }

    public Car[] carSetUp(int numberOfCar) {
        Car[] cars = new Car[numberOfCar];

        for (int i = 0; i < numberOfCar; i++)
            cars[i] = new Car();

        return cars;
    }

    public void run(Car[] cars) {
        for (int i = 0, loop = cars.length; i < loop; i++) {
            cars[i].randomlyGo();
        }
    }

    private void showMovedDistance(Car[] cars) {
        for (int i = 0, loop = cars.length; i < loop; i++)
            cars[i].showMovedDistance();
    }
}
