package racing.service;

import racing.model.Car;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    private final List<Car> cars = new ArrayList<>();
    private ResultView resultView;
    private int NUMBER_OF_ATTEMPTS;

    public ResultView start(int cars, int attempts) {
        init(cars, attempts);
        race();
        return resultView;
    }

    private void init(int cars, int attempts) {
        NUMBER_OF_ATTEMPTS = attempts;
        resultView = new ResultView();

        for (int i = 0; i < cars; i++) {
            this.cars.add(new Car());
        }
    }

    private void race() {
        for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            move();
            resultView.appendNewLine();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move();
            resultView.record(car);
        }
    }

    /**
     * Test Code 작성을 위한 getter() 메서드
     */
    public List<Car> getCars() {
        return this.cars;
    }

}
