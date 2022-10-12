package racing_game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racing_game.core.Positive;

public class SnapShot {

    private final List<Map<CarName, Positive>> holder;
    private String winner;

    public SnapShot() {
        this.holder = new ArrayList<>();
    }

    public void capture(Cars cars) {
        holder.add(mapToDistance(cars));
        winner = cars.getCurrentWinners();
    }

    public String getWinner() {
        return winner;
    }

    private Map<CarName, Positive> mapToDistance(Cars cars) {
        return cars.get()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                Entry::getKey,
                entry -> entry.getValue().getDistance()));
    }

    public List<Map<CarName, Positive>> get() {
        return Collections.unmodifiableList(holder);
    }

}
