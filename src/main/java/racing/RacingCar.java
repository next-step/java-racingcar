package racing;

import view.InputView;
import view.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int turnCount = InputView.getTurn();

        RacingSession session;
        try {
            session = RacingSession.of(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        session.startRacing(turnCount);
        RacingResultDto racingResult = session.getRacingResult();

        ResultView.printResult(racingResult);
    }

}
