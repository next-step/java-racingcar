package racingCar.step5.view;

import racingCar.step5.domain.RacingCarGame;
import racingCar.step5.domain.RacingCars;
import racingCar.step5.domain.RandomNumber;
import racingCar.step5.domain.dto.RacingCarGameResult;

public class RacingCarGameController {

    public void gameStart(){
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();

        String carNames = inputView.getCarNamesFromUser();
        int racingCount = inputView.getRacingCountFromUser();
        RacingCars cars = RacingCars.ofNames(carNames);

        RacingCarGame game = new RacingCarGame(cars, new RandomNumber());
        RacingCarGameResult gameResult = game.start(racingCount);

        resultView.showRaceResults(gameResult.getRacingResults());
        resultView.showRaceChampion(gameResult.getWinners());
    }
}
