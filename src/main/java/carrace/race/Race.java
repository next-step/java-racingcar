package carrace.app;

import carrace.common.Vehicle;
import carrace.movement.car.CarMovement;
import carrace.utils.InputValidator;
import carrace.utils.RandomValue;
import carrace.vehicle.car.Car;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Race {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCar = InputValidator.receiveCarNum(scanner.nextInt());
        int numTry = InputValidator.receiveNumTry(scanner.nextInt());
        Vehicle[] cars = new Car[numCar];

        prepare(cars, numCar);
        start(cars, numCar, numTry);
    }

    public static void prepare(Vehicle[] cars, int numCar) {
        IntStream.range(0, numCar)
                .forEach(
                        i -> {
                            cars[i] = new Car(new CarMovement());
                        });
    }

    private static void start(Vehicle[] cars, int numCar, int numTry) {
        IntStream.range(0, numTry)
                .forEach(
                        i -> {
                            updateCurrentState(cars, numCar);
                            printCurrentState(cars);
                        });
    }

    public static void updateCurrentState(Vehicle[] cars, int numCar) {
        IntStream.range(0, numCar)
                .forEach(
                        j -> {
                            cars[j].move(RandomValue.generate());
                        });
    }

    private static void printCurrentState(Vehicle[] cars) {
        Arrays.stream(cars).forEach(car -> System.out.println(car.getCurrentPosition()));
        System.out.println();
    }
}
