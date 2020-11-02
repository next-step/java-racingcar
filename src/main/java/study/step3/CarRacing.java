package study.step3;

import java.util.*;

import static java.util.AbstractMap.Entry;
import static java.util.AbstractMap.SimpleEntry;
import static java.util.stream.Collectors.toSet;

class CarRacing {

    private final Set<Car> cars;
    private final int steps;
    private final Map<String, List<Boolean>> records = new HashMap<>();

    public CarRacing(Circuit circuit) {
        cars = circuit.getCars();
        steps = circuit.getLaps();
    }

    public void start() {
        for (int i = 0; i < steps; i++) {
            move();
            recording();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void recording() {
        for (Car car : cars) {
            records.computeIfAbsent(car.getName(), key -> new ArrayList<>()) //
                    .add(car.isMoved());
        }
    }

    public boolean hasRecord() {
        return !records.isEmpty();
    }

    public Set<String> getWinners() {
        Integer maxMove = records.values() //
                .stream() //
                .mapToInt(this::countMove)
                .max()
                .orElse(0);

        return records.entrySet() //
                .stream() //
                .map(entry -> new SimpleEntry<>(entry.getKey(), countMove(entry.getValue()))) //
                .filter(entry -> entry.getValue() >= maxMove).map(Entry::getKey) //
                .collect(toSet());
    }

    private int countMove(List<Boolean> values) {
        return values.stream().mapToInt(moved -> moved ? 1 : 0).sum();
    }

    public Map<String, List<Boolean>> getRecords() {
        return records;
    }
}
