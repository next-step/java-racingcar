package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Entry {
    private final List<RacingCar> cars;

    public Entry(List<RacingCar> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void move(RacingRule rule) {
        this.cars.forEach(car -> car.move(rule));
    }

    public SnapShotEntry getSnapshot() {
        return this.cars.stream()
                .map(car -> car.copy())
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        SnapShotEntry::new));
    }
}
