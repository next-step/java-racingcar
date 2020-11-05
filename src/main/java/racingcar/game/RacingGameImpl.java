package racingcar.game;

import racingcar.car.RacingCar;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class RacingGameImpl extends RacingGame {


    @Override
    public void addCarList(List<String> carNames) {
        carNames.forEach(carName -> addCar(new RacingCar(carName)));
    }

    @Override
    public void execute(RacingInfomation infomation, MoveStrategy moveStrategy) {
        infomation.isValidInformation();

        List<String> carNames = infomation.getCarNames();
        int playCount = infomation.getPlayCount();
        addCarList(carNames);

        for (int i = 0; i < playCount; i++) {
            notifyCars((i + 1), moveStrategy);
        }
    }
}
