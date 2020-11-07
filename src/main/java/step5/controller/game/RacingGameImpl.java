package step5.controller.game;

import step5.domain.dto.RacingInfomation;
import step5.domain.model.car.RacingCar;
import step5.strategy.MoveStrategy;

import java.util.List;

public class RacingGameImpl extends RacingGame {


    @Override
    public void appendCarList(List<String> carNames) {
        carNames.forEach(carName -> appendCar(new RacingCar(carName)));
    }

    @Override
    public void play(RacingInfomation infomation, MoveStrategy strategy) {
        infomation.isValidInformation();

        List<String> carNames = infomation.getCarNames();
        int playCount = infomation.getPlayCount();
        appendCarList(carNames);
        execute(playCount, strategy);
    }

    private void execute(int count, MoveStrategy strategy) {
        for (int i = 0; i < count; i++) {
            notifyCars((i + 1), strategy);
        }
    }
}
