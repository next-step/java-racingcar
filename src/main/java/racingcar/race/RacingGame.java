package racingcar.race;

import racingcar.car.Car;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    //TODO : cars RacingGame객체에서 분리하기
    //TODO : ranking 객체 만들기 ( topPosition 저장, winner count저장, sorting 기능 )
    private int time;

    public RacingGame(int time) {
        this.time = time;
    }

    public int game(List<Car> cars) {
        int topPosition = 0;
        for (int i = 0; i < time; i++) {
            topPosition = move(cars, topPosition);
        }

        return topPosition;
    }

    //TODO : 더 좋은 출력방법 있는지 고민해보기..
    public int move(List<Car> cars, int topPosition) {
        for (Car car : cars) {
            int position = car.move();
            topPosition = checkTopPosition(topPosition, position);
            OutputView.showStatus(car.getName(), position);
        }
        OutputView.nextTurn();
        return topPosition;
    }

    private int checkTopPosition(int topPosition, int position) {
        if (topPosition < position) {
            return position;
        }
        return topPosition;
    }
}

