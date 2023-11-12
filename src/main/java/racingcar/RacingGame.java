package racingcar;

import java.util.Scanner;

public class RacingGame {
    private int roundNumber;
    private RacingCar[] cars;

    public void play() {
        int[] inputValues = input();
        makeGame(inputValues);
        startGame();
    }

    private static int[] input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumber = scanner.nextInt();

        return new int[] {carNumber, tryNumber};
    }

    private void makeGame(int[] inputValues) {
        validateInput(inputValues);
        this.makeCars(inputValues[0]);
        this.roundNumber = inputValues[1];
    }

    private void makeCars(int carNumber) {
        this.cars = new RacingCar[carNumber];
        for (int i=0; i<carNumber; i++) {
            this.cars[i] = new RacingCar();
        }
    }

    public static void validateInput(int[] input) {
        for (int i : input) {
            if (i < 0) {
                throw new RuntimeException("Negative numbers are not allowed.");
            }
        }
    }

    private void startGame() {
        for (int i = 0; i<this.roundNumber; i++) {
            this.playOneRound();
            this.printResult(i);
        }
    }

    private void playOneRound() {
        for (RacingCar car : this.cars) {
            car.moveOrStop(RacingCar.getRandomValue());
        }
    }

    private void printResult(int round) {
        if (round == 0) {
            System.out.println();
            System.out.println("실행 결과");
        }

        for (RacingCar car : cars) {
            car.printLocationOfCar();
        }
        System.out.println();
    }
}
