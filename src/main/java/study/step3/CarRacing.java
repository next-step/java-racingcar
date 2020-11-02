package study.step3;

import java.util.HashSet;
import java.util.Set;

class CarRacing {

    private final Set<Car> cars;
    private final int steps;
    private final ResultView resultView;

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
        Set<LapResult> result = new HashSet<>();
        for (Car car : cars) {
            car.move();
            result.add(new LapResult(car.getName(), car.isMoved()));
        }
        resultView.add(result);
    }
}
