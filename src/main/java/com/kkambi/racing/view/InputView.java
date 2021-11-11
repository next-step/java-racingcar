package com.kkambi.racing.view;

import java.util.Scanner;

public class InputView {

    public InputCommand getInput() {
        Scanner scanner = new Scanner(System.in);
        return new InputCommand(getNumberOfCars(scanner), getNumberOfAttempts(scanner));
    }

    private int getNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대인가요?");
        return scanner.nextInt();
    }

    private int getNumberOfAttempts(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회인가요?");
        return scanner.nextInt();
    }

    public static class InputCommand {
        private final int numberOfCars;
        private final int numberOfAttempts;

        public InputCommand(int numberOfCars, int numberOfAttempts) {
            this.numberOfCars = numberOfCars;
            this.numberOfAttempts = numberOfAttempts;
        }

        public int getNumberOfCars() {
            return numberOfCars;
        }

        public int getNumberOfAttempts() {
            return numberOfAttempts;
        }
    }
}
