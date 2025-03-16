package racing;

import view.InputView;
import view.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int turnCount = InputView.getTurn();

        RacingSession session = RacingSession.of(carNames);
        session.startRacing(turnCount);
        RacingResultDto racingResult = session.getRacingResult();

        ResultView.printResult(racingResult);
    }

}
