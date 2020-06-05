package camp.nextstep.edu.nextstep8.racing;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        // Racing input
        RacingGameInput input = new RacingGameInput();
        String cars = input.getCars();
        int raceTimes = input.getRoundTimes();

        // Racing game start
        RacingGame racingGame = new RacingGame(cars, raceTimes);
        List<RacingEntry> record = racingGame.raceStart();

        // Result view
        RacingGameResultView resultView = new RacingGameResultView(record);
        resultView.showResult();
    }
}
