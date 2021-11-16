package racingcar;

import racingcar.domain.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameMain {
    private static final int NUMBER_ZERO = 0;

    public static void main(String[] args)  {
        InputView inputView = new InputView();
        try {
            inputView.startRacingGame();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(NUMBER_ZERO);
        }

        RacingGameService racingGameService = new RacingGameService(inputView.getCarNames(), inputView.getTryCount());
        List<RacingCar> racingCars = racingGameService.makeRacingCars();

        racingGameService.racing(racingCars);
        ResultView resultView = new ResultView();
        resultView.drawRacing(racingCars);

        List<RacingCar> winnerCars = racingGameService.getWinners(racingCars);
        resultView.drawWinner(winnerCars);
    }
}
