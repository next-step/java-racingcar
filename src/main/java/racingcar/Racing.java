package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    public static final int MOVABLE_CRITERIA = 4;
    public static final int POSITION_BOUND = 9;

    static List<Integer> positions;
    static int raceCount;
    static List<List<Integer>> raceResults;

    private static Random random = new Random();

    public static void main(String[] args) {
        Racing.setRace(InputView.askCarCount(), InputView.askRaceCount());
        Racing.startRace();
        OutputView.endRace();
    }

    public static void setRace(int carCountText, int raceCountText) {
        setPositions(carCountText);
        setRaceCount(raceCountText);
    }

    private static void setRaceCount(int raceCount) {
        Racing.raceCount = raceCount;
    }

    private static void setPositions(int carCount) {
        positions = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            positions.add(0);
        }
    }

    public static void startRace() {
        raceResults = new ArrayList<>();
        for (int r = 0; r < raceCount; r++) {
            moveCars();
            saveRaceResult();
        }
    }

    private static void moveCars() {
        int size = positions.size();
        for (int i = 0; i < size; i++) {
            moveCar(i, getNextInt());
        }
    }

    private static void saveRaceResult() {
        List<Integer> result = new ArrayList<>();
        for (int position : positions) {
            result.add(position);
        }
        raceResults.add(result);
    }

    private static void moveCar(int carNumber, int criteria) {
        if (!isMovable(criteria)) {
            return;
        }
        move(carNumber);
    }

    private static int getNextInt() {
        return random.nextInt(POSITION_BOUND + 1);
    }

    private static boolean isMovable(int criteria) {
        return criteria >= MOVABLE_CRITERIA;
    }

    private static void move(int i) {
        positions.set(i, positions.get(i) + 1);
    }

}
