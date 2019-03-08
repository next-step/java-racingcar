package racingcar;

import java.util.Scanner;

public class RacingGame {
    private Car[] cars;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        scanner.close();
        System.out.println();

        carSetUp(numberOfCar);
        start(tryCount);
    }

    public void start(int tryCount) {
        System.out.println("실행 결과\n");

        for (int i = 0; i < tryCount; i++) {
            run();
            showMovedDistanceOfCars(cars);
            System.out.println();
        }
    }

    public Car[] carSetUp(int numberOfCar) {
        this.cars = new Car[numberOfCar];

        for (int i = 0; i < numberOfCar; i++)
            this.cars[i] = new Car();

        return this.cars;
    }

    private void run() {
        for (int i = 0, loop = this.cars.length; i < loop; i++)
            this.cars[i].randomlyGo();
    }

    private void showMovedDistanceOfCars(Car[] cars) {
        for (int i = 0, loop = cars.length; i < loop; i++)
            cars[i].showMovedDistance();
    }
}
