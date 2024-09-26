package racing.race;

import java.util.ArrayList;
import java.util.List;

import static racing.Constants.*;

public class Car {

    private final List<Integer> forwardResults = new ArrayList<>();

    public void forward(boolean isForward) {
        forwardResults.add(isForward ? FORWARD : STOP);
    }

    public int raceResult(int index) {
        return forwardResults.get(index);
    }
}
