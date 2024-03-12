package race;

import java.util.Scanner;

public class RacingGameMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberOfAttempt = scanner.nextInt();

        Cars cars = new Cars(numberOfCars);

        RacingGame game = new RacingGame();
        game.start(cars, numberOfCars, numberOfAttempt);

    }

}
