package study.step3;

import java.util.*;

class CarRacing {

    private final Set<Car> cars;
    private final int steps;
    private final ResultView resultView;
    private final Map<String, List<Boolean>> records = new HashMap<>();

    public CarRacing(Circuit circuit, ResultView resultView) {
        cars = circuit.getCars();
        steps = circuit.getLaps();
        this.resultView = resultView;
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
}
