package racingcar;

import racingcar.domain.RacingRecord;
import racingcar.domain.RacingResult;
import racingcar.view.ResultView;
import racingcar.view.UserConsole;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = RacingController.getInstance(UserConsole.names(), UserConsole.turn().getValue());

        RacingResult racingResult = racingController.start();
        RacingRecord racingRecord = racingController.getRaceRecord();

        ResultView.printRacingResult(racingRecord.getResultRecord());
        ResultView.printWinner(racingResult.getWinner());
    }
}