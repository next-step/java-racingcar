package domain;

import view.InputView;

import java.util.Random;

public class RacingGame {
    private final Random random = new Random();

    public void start() {
        int numberOfCars = InputView.inputNumberOfCar();
        int time = InputView.inputTime();

        int[] cars = new int[numberOfCars];

        System.out.println("실행 결과");
        for(int i = 0; i < time; i++) {
            for (int j = 0; j < numberOfCars; j++) {
                cars[j] += this.move();
                System.out.println(print(cars[j]));
            }
            System.out.println();
        }
    }

    private String print(int number) {
        String movement = "";

        for (int i = 0; i < number; i++) {
            movement = movement.concat("-");
        }

        return movement;
    }

    private int move() {
        int randomNumber = random.nextInt(10);
        return randomNumber > 3 ? 1 : 0;
    }
}
