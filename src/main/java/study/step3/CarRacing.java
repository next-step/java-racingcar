package study.step3;

import java.util.HashSet;
import java.util.Set;

class CarRacing {

    private final Set<Car> cars;
    private final int steps;
    private final ResultView resultView;

    public CarRacing(RacingInfoProvider racingInfoProvider, ResultView resultView) {
        cars = racingInfoProvider.getCars();
        steps = racingInfoProvider.countSteps();
        this.resultView = resultView;
    }

    public CarRacing(Circuit circuit, ResultView resultView) {
        cars = circuit.getCars();
        steps = circuit.getLaps();
        this.resultView = resultView;
    }

    public void start() {
        if (cars.isEmpty() || steps <= 0) {
            throw new IllegalStateException("레이싱 정보가 존재하지 않습니다.");
        }

        for (int i = 0; i < steps; i++) {
            move();
        }
    }

    private void move() {
        Set<LapResult> result = new HashSet<>();
        for (Car car : cars) {
            car.move();
            result.add(new LapResult(car.getId(), car.isMoved()));
        }
        resultView.add(result);
    }
}
