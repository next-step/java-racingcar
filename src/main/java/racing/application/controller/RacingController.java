package racing.application.controller;

import racing.application.service.RacingService;
import racing.application.view.OutputView;
import racing.application.view.View;
import racing.domain.car.CarRace;
import racing.domain.car.exception.BelowOfZeroException;
import racing.domain.car.exception.UnderOfZeroException;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public View racingGame(int numberOfCars, int moveCount) {
        validation(numberOfCars, moveCount);
        CarRace carRace = racingService.makeCars(numberOfCars);

        return new OutputView(racingService.scoreBoard(carRace, moveCount));
    }

    private void validation(int numberOfCars, int moveCount) {
        if (numberOfCars <= 0) {
            throw new BelowOfZeroException("자동차는 1대 이상 입력 해야 합니다.");
        }
        if (moveCount < 0) {
            throw new UnderOfZeroException("0번 이상 움직여야 합니다.");
        }
    }
}
