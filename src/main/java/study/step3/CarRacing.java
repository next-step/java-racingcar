package study.step3;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.AbstractMap.Entry;
import static java.util.AbstractMap.SimpleEntry;
import static java.util.Comparator.comparingInt;
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
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move();
            record(car);
        }
    }

    private void record(Car car) {
        records.computeIfAbsent(car.getName(), key -> new ArrayList<>()) //
                .add(car.isMoved());
    }

    public boolean hasRecord() {
        return !records.isEmpty();
    }

    public Set<String> getWinners() {
        AtomicInteger maxMove = new AtomicInteger();

        return records.entrySet() //
                .stream() //
                .map(entry -> new SimpleEntry<>(entry.getKey(), countMove(entry))) //
                .sorted(comparingInt(SimpleEntry::getValue)) //
                .filter(entry -> {
                    if (entry.getValue() >= maxMove.get()) {
                        maxMove.set(entry.getValue());
                        return true;
                    }
                    return false;
                }).map(Entry::getKey) //
                .collect(toSet());
    }

    private int countMove(Entry<String, List<Boolean>> entry) {
        return entry.getValue().stream().mapToInt(moved -> moved ? 1 : 0).sum();
    }

    public Map<String, List<Boolean>> getRecords() {
        return records;
    }
}
