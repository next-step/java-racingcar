package racing_game.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racing_game.core.Positive;

public class Cars {

    private final Map<CarName, Car> holder;

    private Cars(List<CarName> names) {
        holder = new LinkedHashMap<>();
        for (CarName name : names) {
            holder.put(name, Car.create());
        }
    }

    public static Cars create(List<CarName> names) {
        return new Cars(names);
    }

    public void moveAll(MovingStrategy movingStrategy) {
        for (Entry<CarName, Car> entry : holder.entrySet()) {
            Car car = entry.getValue();
            car.move(movingStrategy);
        }
    }

    public String getCurrentWinners() {
        Positive maxDistance = getCurrentMaxDistance();
        return holder.entrySet()
            .stream()
            .filter(e -> e.getValue().getDistance().equals(maxDistance))
            .map(e -> e.getKey().toString())
            .collect(Collectors.joining(","));
    }

    private Positive getCurrentMaxDistance() {
        return holder.entrySet()
            .stream()
            .max(
                Comparator.comparingInt(carEntry -> carEntry.getValue().getDistance().toInt()))
            .orElseThrow()
            .getValue()
            .getDistance();
    }

    public Map<CarName, Car> get() {
        return Collections.unmodifiableMap(holder);
    }

    public int size() {
        return holder.size();
    }
}
