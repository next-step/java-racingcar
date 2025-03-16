package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    public static final int MIN_PROGRESS_NUMBER = 4;

    public static List<List<Integer>> activeTurns(List<Car> cars, int turn) {
        List<List<Integer>> totalPositions = new ArrayList<>();
        for (int i = 0; i < turn; i++) {
            totalPositions.add(moveCars(cars));
        }
        return totalPositions;
    }

    public static List<Integer> moveCars(List<Car> cars) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.active(canProgress(getRandom())));
        }
        return positions;
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean canProgress(int randomNumber) {
        return randomNumber >= MIN_PROGRESS_NUMBER;
    }
}
