package racing;

import racing.domain.CarRacing;
import racing.view.RacingInputView;
import racing.view.RacingResultView;

public class CarRacingMain {

    public static void main(String[] args) {
        int carCount = RacingInputView.carCount();
        int raceCount = RacingInputView.raceCount();

        CarRacing carRacing = new CarRacing(carCount, raceCount);

        RacingResultView.printHeader();
        while (!carRacing.isComplete()) {
            carRacing.race(RacingResultView::printCarMovedDistance);
            RacingResultView.printFooter();
        }
    }
}
