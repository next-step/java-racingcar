package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.view.ResultView;

import static racing.util.Random.createRandomValue;

public class RacingGame {
    private final Cars cars;
    private static final ResultView resultView = new ResultView();
    private Integer tryCount;

    RacingGame(int carCount, int tryCount) {
        cars = new Cars(carCount);
        this.tryCount = tryCount;
    }

    public void tryEvent() {
        for (int i = 0; i < tryCount; i++) {
            System.out.println("");
            moveEvent(createRandomValue());
        }
    }

    private void moveEvent(int randomValue) {
        for (Car car : cars.getCars()) {
            car.move(randomValue);
            resultView.result(car.getDistance());
        }
    }
}
