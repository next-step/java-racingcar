import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Race {

    private static final Random random = new Random();
    private static final int MOVEMENT_THRESHOLD = 4;
    private final int carCount;
    private final int totalRounds;
    private final List<Integer> carPositions;
    private int currentRound = 0;

    public Race(int carCount, int totalRounds) {
        if (carCount < 1 || totalRounds < 1) {
            throw new IllegalArgumentException();
        }

        this.carCount = carCount;
        this.totalRounds = totalRounds;
        this.carPositions = new ArrayList<>(Collections.nCopies(carCount, 0));
    }

    public List<Integer> getCarPositions() {
        return List.of(carPositions.toArray(new Integer[0]));
    }

    public void runRound() {
        if (isRaceFinished()) {
            throw new IllegalStateException("Race has already finished");
        }

        for (int i = 0; i < carCount; i++) {
            carPositions.set(i, getCarPositionAfterMove(carPositions.get(i), random.nextInt(10)));
        }
        currentRound++;
    }

    public boolean isRaceFinished() {
        return currentRound >= totalRounds;
    }

    public int getCarPositionAfterMove(int initialPosition, int seed) {
        if (seed < 0 || seed > 9) {
            throw new IllegalArgumentException("Invalid seed: " + seed);
        }

        if (seed >= MOVEMENT_THRESHOLD) {
            return initialPosition + 1;
        }
        return initialPosition;
    }
}
