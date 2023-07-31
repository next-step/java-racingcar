package edu.nextstep.camp.racing.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingResult {

    private static final String POSITION_BAR = "-";
    private final Map<String, Integer> positions;

    public RacingResult(List<Car> cars) {
        Objects.requireNonNull(cars);

        this.positions = new LinkedHashMap<>();

        cars.forEach(c -> positions.put(c.toString(), c.currentPosition()));
    }

    @Override
    public String toString() {
        return positions.keySet().stream()
                .map(k -> k + " : " + POSITION_BAR.repeat(positions.get(k)))
                .collect(Collectors.joining("\n"));
    }
}
