package autoracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private static final Random RANDOM = new Random();
    private static final int DRIVING_THRESHOLD = 4;

    private final List<Movement> history;

    public Car() {
        this.history = new ArrayList<>();
    }

    public List<Movement> getHistory() {
        return new ArrayList<>(history);
    }

    public void race() {
        race(RANDOM.nextInt(10));
    }

    public void race(int randomValue) {
        if (canGoForward(randomValue)) {
            history.add(Movement.ONE_FORWARD);
            return;
        }
        history.add(Movement.STATIONARY);
    }

    private boolean canGoForward(int randomValue) {
        return randomValue >= DRIVING_THRESHOLD;
    }
}
