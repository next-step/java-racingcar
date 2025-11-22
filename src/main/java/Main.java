import ui.CarRacingGame;

import java.util.Scanner;

public class Main {
    private static final String CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?";
    private static final String CAR_MOVE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CarRacingGame carRacingGame = new CarRacingGame();

        System.out.println(CAR_COUNT_INPUT_MESSAGE);
        int carCount = scanner.nextInt();
        carRacingGame.setUp(carCount);

        System.out.println(CAR_MOVE_COUNT_INPUT_MESSAGE);
        int tryCount = scanner.nextInt();
        carRacingGame.race(tryCount);
    }
}
