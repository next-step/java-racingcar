import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Race {

    private final int carCount;
    private final int totalRounds;

    private List<Integer> carPositions;
    private int currentRound = 0;

    private static final Random random = new Random();

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
        if (currentRound >= totalRounds) {
            throw new IllegalStateException("Race has already finished");
        }

        for (int i = 0; i < carCount; i++) {
            carPositions.set(i, move(carPositions.get(i), random.nextInt(10)));
        }
        currentRound++;
    }

    private int move(int initialPosition, int seed) {
        if (seed >= 4) return initialPosition + 1;
        return initialPosition;
    }
}
