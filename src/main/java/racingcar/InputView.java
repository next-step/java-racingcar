package racingcar;

import java.util.Scanner;

public class InputView {
    public InputResult input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTries = scanner.nextInt();

        return new InputResult(numberOfCars, numberOfTries);
    }

    static class InputResult {
        private int numberOfCars;
        private int numberOfTries;

        public InputResult(int numberOfCars, int numberOfTries) {
            this.numberOfCars = numberOfCars;
            this.numberOfTries = numberOfTries;
        }

        public int getNumberOfCars() {
            return numberOfCars;
        }

        public int getNumberOfTries() {
            return numberOfTries;
        }
    }
}
