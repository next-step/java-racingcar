package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int runNumber = scanner.nextInt();

        new RacingGame().run(carNumber, runNumber);

    }

    private void run(int carNumber, int runNumber) {

        createCars(carNumber);

        for (int i = 0; i < runNumber; i++) {
            doCycle();
            printStatus();
        }

    }

    private void createCars(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
    }

    private void doCycle() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printStatus() {
        for (Car car : cars) {
            System.out.println(drawLocation(car.getLocation()));
        }

        System.out.println();
    }

    private String drawLocation(int location) {
        StringBuilder locationBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            locationBuilder.append("-");
        }
        return locationBuilder.toString();
    }
}
