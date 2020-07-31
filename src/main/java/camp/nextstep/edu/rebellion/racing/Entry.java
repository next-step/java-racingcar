package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Entry {
    private static final String POSITION_LANE = "-";
    private static final String ENTER = "\n";
    private final List<RacingCar> cars;

    public Entry(List<RacingCar> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void move(RacingRule rule) {
        this.cars.forEach(car -> car.move(rule));
    }

    public String getAllPositionLanes() {
        return this.cars.stream()
                .map(car -> makeLane(car.getPosition()))
                .collect(Collectors.joining(ENTER));
    }

    private String makeLane(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_LANE);
        }
        return builder.toString();
    }
}
