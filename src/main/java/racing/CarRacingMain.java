package racing;

import racing.domain.CarRacing;

import static racing.view.CarRacingInputView.carNames;
import static racing.view.CarRacingInputView.countOfRace;
import static racing.view.CarRacingResultView.*;

public class CarRacingMain {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(carNames(), countOfRace());

        printRacingResultHeader();

        carRacing.race(printRacingResult(), printRaceFooter());
        printRacingWinners(carRacing.getWinnerCarNames());
    }
}
