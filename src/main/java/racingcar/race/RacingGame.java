package racingcar.race;

import racingcar.car.Car;
import racingcar.view.OutputView;

import java.util.Collections;
import java.util.List;

public class RacingGame {

    private int time;

    public RacingGame(int time) {
        this.time = time;
    }

    public List<Car> game(List<Car> cars) {
        for (int i = 0; i < time; i++) {
            move(cars);
        }
        //sort
        Collections.sort(cars);
        return cars;
    }

    //TODO : 더 좋은 출력방법 있는지 고민해보기..
    public void move(List<Car> cars) {
        for (Car car : cars) {
            int position = car.move();
            OutputView.showStatus(car.getName(), position);
        }
        OutputView.nextTurn();
    }
}

