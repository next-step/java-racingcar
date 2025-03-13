package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    public static List<List<Integer>> activeTurns(List<Car> cars, int turn) {
        List<List<Integer>> totalPositions = new ArrayList<>();
        for (int i = 0; i < turn; i++) {
            totalPositions.add(activeCars(cars));
        }
        return totalPositions;
    }

    public static List<Integer> activeCars(List<Car> cars) {
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
        return randomNumber >= 4;
    }
}
