package racingcar.game;

import racingcar.car.Cars;
import racingcar.gameinfo.GameInfo;
import racingcar.view.ResultView;

public class RacingCarGame {

    private final GameInfo info;
    private final Cars cars;

    public RacingCarGame(GameInfo info) {
        this.info = info;
        this.cars = info.getCars();
    }

    public void start() {
        for(int count = 0; count < this.info.getTryCount() ; count++){
            cars.playGame(this.info.getMoveRule());
            ResultView.print(this.cars);
        }
    }
}