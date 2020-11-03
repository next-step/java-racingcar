package racingcar.game;

import racingcar.Constant;
import racingcar.car.RacingCar;
import racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.Objects;

public class RacingGameImpl extends RacingGame {


    @Override
    public void addCarList(int number, MoveStrategy moveStrategy) {
        for (int i = 0; i < number; i++) {
            addCar(new RacingCar(moveStrategy));
        }
    }

    @Override
    public void addCarList(List<String> carNames, MoveStrategy moveStrategy) {
        carNames.forEach(carName -> addCar(new RacingCar(moveStrategy, carName)));
    }

    @Override
    public void execute(RacingInfomation infomation, MoveStrategy moveStrategy) {
        isValidInformation(infomation);

        List<String> carNames = infomation.getCarNames();
        int playCount = infomation.getPlayCount();
        addCarList(carNames, moveStrategy);

        for (int i = 0; i < playCount; i++) {
            notifyCars(i + 1);
        }
    }


    private void isValidInformation(RacingInfomation infomation) {
        if (Objects.isNull(infomation) || (infomation.getPlayCount() <= 0)) {
            throw new IllegalArgumentException(Constant.EMPTY_NULL_ERROR);
        }
    }
}
