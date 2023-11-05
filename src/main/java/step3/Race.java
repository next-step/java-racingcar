package step3;

import step3.validation.ValidateRaceTimeInput;

import java.util.Random;
import java.util.Scanner;

import static step3.constants.QuestionConstants.HOW_MANY_TIMES;

public class Race {

    private static final Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 10;

    public static int raceTimeInput(Scanner scanner) {
        System.out.println(HOW_MANY_TIMES);
        int times = scanner.nextInt();

        return ValidateRaceTimeInput.range(times);
    }

    public static void playing(int cars, int times) {
        String[] board = new String[cars];

        for (int time = 1; time <= times; time++) {
            for (int car = 1; car <= cars; car++) {
                if (Cars.isMovable(getRandomValue())) {
                    board[car - 1] = Cars.go(board[car - 1]);
                }
            }

            RaceResult.show(board);
        }
    }

    public static int getRandomValue() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}

