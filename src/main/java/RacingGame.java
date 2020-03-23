import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final Integer LIMIT = 10;
    private static final Integer THRESHOLD = 4;
    private static final Integer ZERO = 0;

    static List<List<Integer>> start(int car, int stage) {

//        init cars
        List<Integer> cars = new ArrayList<>();
        for (int i = 0; i < car; i++) {
            cars.add(0);
        }


        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < stage; i++) {
            cars = move(cars);
            results.add(cars);
        }

        return results;

    }

    private static List<Integer> move(List<Integer> cars) {
        return cars.stream().map(car -> {
            car += getMoveCount();
            return car;
        }).collect(Collectors.toList());
    }


    private static int getMoveCount() {
        int move = getRandom();
        return isMovable(move) ? move : ZERO;
    }

    private static int getRandom() {
        return new Random().nextInt(LIMIT);
    }

    public static boolean isMovable(int moveCount) {
        return moveCount >= THRESHOLD;
    }
}

