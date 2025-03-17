import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {

    private final int carCount;
    private final int roundCount;
    private final List<Integer> carPositions;

    public Race(int carCount, int roundCount) {
        if (carCount < 1 || roundCount < 1) {
            throw new IllegalArgumentException();
        }

        this.carCount = carCount;
        this.roundCount = roundCount;
        this.carPositions = new ArrayList<>(Collections.nCopies(carCount, 0));
    }

    public List<Integer> getCarPostions() {
        return carPositions;
    }
}
