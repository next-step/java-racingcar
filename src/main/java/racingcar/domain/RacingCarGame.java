package racingcar.domain;

import java.util.List;
import racingcar.view.ResultView;
public class RacingCarGame {

    private final List<Car> cars;
    private int tryCount;

    public RacingCarGame(Cars cars, int tryCount) {
        this.cars = cars.getCars();
        this.tryCount = tryCount;
    }

    public void play() {
        do {
            loadGame();
            ResultView.printGameStatus(cars);
            ResultView.printGameResultBlankLine();

            tryCount--;
        } while (tryCount > 0);
    }

    private void loadGame() {
        for (Car car : cars) {
            //TODO: 랜덤한 값을 마지막에 넣는다
            int randomMove = Movement.getRandomMove();
            car.move(randomMove);
        }
    }
}
