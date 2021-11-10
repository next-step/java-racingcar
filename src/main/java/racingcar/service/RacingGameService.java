package racingcar.service;

import racingcar.domain.GameInputData;
import racingcar.domain.RacingCar;
import racingcar.domain.collection.CarCollection;
import racingcar.service.util.RacingUtil;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameService {

    private List<RacingCar> cars;

    private RacingGameService(int carCount) {
        cars = CarCollection.racingGameReady(carCount);
    }

    public static RacingGameService ready(int carCount) {
        return new RacingGameService(carCount);
    }

    public void execute(GameInputData racingCarInput) {

        int tryCount = racingCarInput.getTryCount();

        for(int i = 0; i < tryCount; i++) {
            RacingUtil.playTheGame(cars);
            ResultView.print(cars);

            System.out.println();
        }
    }

}
