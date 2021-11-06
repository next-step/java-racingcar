package racingcar.game;

import racingcar.car.Car;
import racingcar.car.CarCreator;
import racingcar.gameinfo.RacingCarGameInfo;
import racingcar.view.ResultView;

import java.util.*;

public class RacingCarGame implements Game {

    private final RacingCarGameInfo info;
    private final List<Car> carList;

    public RacingCarGame(RacingCarGameInfo info) {
        this.info = info;
        this.carList = CarCreator.create(info.getCarCount());
    }

    @Override
    public void start() {
        for(int count = 0; count < this.info.getTryCount() ; count++){
            info.getRound().play(this.carList);
            ResultView.print(this.carList);
        }
    }
}