package racing;

import racing.domain.Car;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static racing.util.Random.createRandomValue;

public class RacingGame {
    private static final List<Car> cars = new ArrayList<>();
    private static final ResultView resultView = new ResultView();
    private Integer tryCount;

    RacingGame(int carCount, int tryCount) {
        for(int i = 0; i < carCount; i++){
            cars.add(new Car());
        }
        this.tryCount = tryCount;
    }

    public void tryEvent() {
        resultView.init();
        for (int i = 0; i < tryCount; i++) {
            System.out.println("");
            moveEvent(createRandomValue());
        }
    }

    public static void moveEvent(int randomValue) {
        for (Car car : cars) {
            car.move(randomValue);
            resultView.result(car.getDistance());
        }
    }
}