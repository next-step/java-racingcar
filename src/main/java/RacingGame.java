import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int LIMIT = 10;
    private static final int THRESHOLD = 4;
    private static final int ZERO = 0;
    private static final int INIT = 0;

    private int car = 0;
    private int stage = 0;

    private RacingGame() {}

    private static class InnerRacingGame {
        private static final RacingGame INSTANCE = new RacingGame();

    }

    static RacingGame getInstance() {
        return InnerRacingGame.INSTANCE;
    }


    List<List<Integer>> start() {
        return start(car, stage);
    }

    List<List<Integer>> start(int car, int stage) {
        List<Integer> cars = new ArrayList<>();
        for (int i = 0; i < car; i++) {
            cars.add(INIT);
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

    static boolean isMovable(int moveCount) {
        return moveCount >= THRESHOLD;
    }

    public int getCar() {
        return car;
    }

    void setCar(int car) {
        this.car = car;
    }

    public int getStage() {
        return stage;
    }

    void setStage(int stage) {
        this.stage = stage;
    }
}

