package racingCar.step5.view;

import racingCar.step5.domain.RacingCar;
import racingCar.step5.domain.RacingCarGame;
import racingCar.step5.domain.RacingCars;
import racingCar.step5.domain.RandomNumber;
import racingCar.step5.domain.dto.RaceResult;
import racingCar.step5.domain.dto.RacingCarGameResult;
import racingCar.step5.domain.dto.WinnerDto;

import java.util.List;

public class RacingCarGameController {

    public void gameStart(){
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();

        String carNames = inputView.getCarNamesFromUser();
        int racingCount = inputView.getRacingCountFromUser();
        RacingCars cars = RacingCars.ofNames(carNames);

        RacingCarGame game = new RacingCarGame(cars, new RandomNumber());

        List<RaceResult> raceResult = RacingCarGameResult.raceResultFrom(game.start(racingCount));
        List<WinnerDto> winnerResult = RacingCarGameResult.winnersFrom(game.decideWinner());

        resultView.showRaceResults(raceResult);
        resultView.showRaceChampion(winnerResult);
    }
}
