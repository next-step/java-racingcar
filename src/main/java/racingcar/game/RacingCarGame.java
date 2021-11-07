package racingcar.game;

import racingcar.car.Cars;
import racingcar.gameinfo.GameInfo;
import racingcar.view.ResultView;

public class RacingCarGame {

    private final int tryCount;
    private final Cars cars;

    public RacingCarGame(GameInfo info) {
        this.tryCount = info.getTryCount();
        this.cars = info.getCars();
    }

    public void start() {
        for(int count = 0; count < this.tryCount ; count++){
            cars.playGame();
            ResultView.print(this.cars);
        }
    }
}