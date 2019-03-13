package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.view.console.OutputView;

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

        return Ranking.sortRanking(cars);
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

