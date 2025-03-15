package racingcar;

import java.util.List;

public class RacingCarService {

    private final List<Car> cars;
    private final int tryCount;
    private final ResultView resultView;

    public RacingCarService(List<Car> cars, int tryCount, ResultView resultView) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.resultView = resultView;
    }

    public void process() {
        resultView.printResult();
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            resultView.printCars(this.cars);
        }
    }
}
