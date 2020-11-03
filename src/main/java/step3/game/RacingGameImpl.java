package step3.game;

import step3.Constant;
import step3.strategy.MoveStrategy;
import step3.car.RacingCar;

import java.util.Objects;

public class RacingGameImpl extends RacingGame {

    @Override
    public void addCarList(int number) {
        for (int i = 0; i < number; i++) {
            addCar(new RacingCar());
        }
    }

    @Override
    public void addCarList(int number, MoveStrategy moveStrategy) {
        for (int i = 0; i < number; i++) {
            addCar(new RacingCar(moveStrategy));
        }
    }

    @Override
    public void execute(RacingInfomation infomation, MoveStrategy moveStrategy) {
        isValidInformation(infomation);

        int number = infomation.getNumberOfCar();
        int playCount = infomation.getPlayCount();
        addCarList(number, moveStrategy);

        for (int i = 0; i < playCount; i++) {
            notifyCars(i+1);
        }
    }

    private void isValidInformation(RacingInfomation infomation) {
        if (Objects.isNull(infomation)||(infomation.getNumberOfCar() <= 0 && infomation.getPlayCount() <= 0)) {
            throw new IllegalArgumentException(Constant.EMPTY_NULL_ERROR);
        }
    }
}
