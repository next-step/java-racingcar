package racingStep3.service;

import racingStep3.domain.GameInputData;
import racingStep3.domain.RacingCar;
import racingStep3.view.InputView;
import racingStep3.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private static List<RacingCar> cars;

    public void execute() {

        InputView inputView = new InputView();
        GameInputData racingCarInput = inputView.getRacingCarInput();
        int carCount = racingCarInput.getCarCount();
        int tryCount = racingCarInput.getTryCount();

        racingGame(carCount);

        for(int i = 0; i < tryCount; i++) {
            RacingUtil.playTheGame(cars);
            ResultView.print(cars);

            System.out.println();
        }
    }

    public static void racingGame(int count) {
        Validation.validCarsCount(count);

        cars = Stream.generate(RacingCar::create)
                .limit(count).collect(Collectors.toList());
    }

}
