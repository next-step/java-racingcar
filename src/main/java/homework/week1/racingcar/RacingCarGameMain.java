package homework.week1.racingcar;

import homework.week1.racingcar.domain.RacingCarGame;
import homework.week1.racingcar.domain.RacingCarGameResult;
import homework.week1.racingcar.view.RacingCarGameInPutView;
import homework.week1.racingcar.view.RacingCarGameResultView;

public class RacingCarGameMain {
    public static void main(String[] args) {
        RacingCarGameInPutView inPutView = RacingCarGameInPutView.newInstance();
        RacingCarGameResultView resultView = RacingCarGameResultView.newInstance();

        String carStrings = inPutView.inputCarName();
        String numberOfRacing = inPutView.inputNumberOfRacing();

        RacingCarGame racingCarGame = new RacingCarGame(carStrings, numberOfRacing);
        int tryNumberOfRacing = 0;
        RacingCarGameResult result = null;
        while (!racingCarGame.isFinishRace(tryNumberOfRacing)) {
            ++tryNumberOfRacing;
            result = racingCarGame.tryRace();
            resultView.printRaceResultCars(result);
            resultView.printEmptyLine();
        }

        if (result != null) {
            resultView.printWinnerCars(result.getWinnerNames(result.getMaxPosition()));
        }
    }
}
