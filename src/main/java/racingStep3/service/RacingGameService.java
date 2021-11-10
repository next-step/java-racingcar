package racingStep3.service;

import racingStep3.domain.GameInputData;
import racingStep3.domain.RacingCar;
import racingStep3.domain.collection.CarCollection;
import racingStep3.service.util.RacingUtil;
import racingStep3.view.InputView;
import racingStep3.view.ResultView;

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
