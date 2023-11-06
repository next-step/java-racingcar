package step3;

import java.util.Random;

public class Race {

    private static final Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 10;

    public static void playing(int cars, int times) {
        String[] board = new RaceBoard(cars).generate();

        for (int time = 1; time <= times; time++) {
            for (int car = 1; car <= cars; car++) {
                if (Cars.isMovable(getRandomValue())) {
                    board[car - 1] = new Cars(board[car - 1]).go();
                }
            }

            new RaceResult(board).show();
        }
    }

    public static int getRandomValue() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}

