package racingcar;

import java.util.Scanner;

public class RacingCarProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        RacingCarGame carGame = new RacingCarGame(new RacingCars(numberOfCar), tryCount);
        carGame.playRacingGame();
        carGame.showRacingResult();

    }
}
