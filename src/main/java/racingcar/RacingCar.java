package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.Arrays;
import java.util.Random;

public class RacingCar {
    public static void racingCar() {
        int car = InputView.inputNumberOfCar();
        int num = InputView.inputNumberOfAttempts();

        ResultView.viewRacingCar(racing(car, num));
    }

    public static int[][] racing(int car, int num) {

        int[][] moves = new int[num][car];
        for (int i = 0; i < num; i++) {
            if (i > 0) {
                moves[i] = moves[i - 1].clone();
            }
            moves[i] = moveCar(car, moves[i]);
        }
        return moves;
    }

    public static int[] moveCar(int car, int[] moves) {
        for (int j = 0; j < car; j++) {
            if (moves[j] == 0) {
                Arrays.fill(moves, 1);
                return moves;
            }
            if (getRandomNumber() >= 4) {
                moves[j]++;
            }
        }
        return moves;
    }

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
