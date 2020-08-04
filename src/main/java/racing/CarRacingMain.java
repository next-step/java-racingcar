package racing;

import racing.domain.CarRacing;
import racing.view.RacingInputView;
import racing.view.RacingResultView;

public class CarRacingMain {

    public static void main(String[] args) {
        String carNames = RacingInputView.carNames();
        int raceCount = RacingInputView.raceCount();

        CarRacing carRacing = new CarRacing(carNames, raceCount);

        RacingResultView.printHeader();
        while (!carRacing.isComplete()) {
            carRacing.race(RacingResultView::printCarMovedDistance);
            RacingResultView.printFooter();
        }
    }
}
