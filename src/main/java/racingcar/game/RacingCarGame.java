package racingcar.game;

import racingcar.car.Cars;
import racingcar.gameinfo.CountInfo;
import racingcar.moverule.MoveRule;
import racingcar.view.ResultView;

public class RacingCarGame {

    private final CountInfo info;
    private final Cars cars;

    public RacingCarGame(CountInfo info, MoveRule moveRule) {
        this.info = info;
        this.cars = new Cars(moveRule, info.getCarCount());
    }

    public void start() {
        for(int count = 0; count < this.info.getTryCount() ; count++){
            cars.play();
            ResultView.print(this.cars);
        }
    }
}