package racing.race;

import java.util.*;

import static racing.Constants.*;

public class Car {

    private final Queue<Integer> forwardResults = new LinkedList<>();

    public void forward(boolean isForward) {
        forwardResults.add(isForward ? FORWARD : STOP);
    }

    public int raceResult() {
        return Optional.ofNullable(forwardResults.poll())
                .orElseThrow(() -> new IndexOutOfBoundsException("최대 경주 횟수를 초과하였습니다."));
    }
}
