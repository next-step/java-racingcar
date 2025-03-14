package racingcar.racing;

import racingcar.racing.model.Car;
import racingcar.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars;
    private int stage;
    private ResultView resultView;

    public Game(int carSize) {
        this.stage = 0;
        this.resultView = new ResultView();

        init(carSize);
    }

    private void init(int carSize) {
        this.cars = new ArrayList<>(carSize);

        for (int i = 0; i < carSize; i++)
            this.cars.add(new Car());
    }

    public void start() {
        // 한번의 횟수에 진행할 로직

        // view
        resultView.view(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getStage() {
        return stage;
    }
}
