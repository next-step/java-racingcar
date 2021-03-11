package new_racingcar;

import java.util.ArrayList;
import java.util.List;

public class GrandPrix {
    private ResultView resultView;

    public GrandPrix() {
        this.resultView = new ResultView();
    }

    public void start(int playerCount, int turnCount) {
        List<Car> cars = createCar(playerCount);

        resultView.printGameStart();

        for(int i = 0; i < turnCount; i++) {
            turn(cars);
            resultView.printGrandPrixRecords(cars);
        }
    }

    public List<Car> createCar(int playerCount) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < playerCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public void turn(List<Car> cars) {
        cars.stream()
                .forEach(c -> c.move(RandomUtil.getValue()));
    }
}
