package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private static final int CHECK_VALUE = 4;
    private static final int INCREASE_VALUE = 1;
    private static final int RANDOM_BOUND = 10;
    private int[] carPositions = {};
    private int time = 0;

    public RacingGame() {
    }

    public RacingGame(int[] carPositions, int time) {
        this.carPositions = carPositions;
        this.time = time;
    }

    public void move(int index, int randomValue) {
        if (checkMove(randomValue)) {
            carPositions[index] = add(carPositions[index]);
        }
    }

    private static int add(int carPosition) {
        return carPosition + INCREASE_VALUE;
    }

    private static boolean checkMove(int value) {
        return value >= CHECK_VALUE;
    }

    private static int randomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String cars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String count = scanner.nextLine();

        RacingGame racingGame = new RacingGame(new int[Integer.parseInt(cars)], Integer.parseInt(count));
        ResultView resultView = new ResultView();

        for (int i = 0; i < racingGame.time; i++) {
            for (int j = 0; j < racingGame.carPositions.length; j++) {
                int randomValue = randomValue();
                racingGame.move(j, randomValue);
                resultView.showResult(racingGame.carPositions[j]);
            }
            System.out.println();
        }
    }
}
