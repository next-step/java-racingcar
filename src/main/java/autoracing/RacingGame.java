package autoracing;

import java.util.Scanner;

public class RacingGame {
    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?";
    private static final String QUESTION_ROUNDS = "시도할 횟수는 몇 회인가요?";

    private int numberOfCars;
    private int rounds;

    public RacingGame(int numberOfCars, int rounds) {
        this.numberOfCars = numberOfCars;
        this.rounds = rounds;
    }

    public static RacingGame createFromConsole() {
        Scanner scan = new Scanner(System.in);
        System.out.println(QUESTION_NUMBER_OF_CARS);
        int numberOfCars = Integer.parseInt(scan.nextLine().trim());
        System.out.println(QUESTION_ROUNDS);
        int rounds = Integer.parseInt(scan.nextLine().trim());
        scan.close();
        return new RacingGame(numberOfCars, rounds);
    }
}
