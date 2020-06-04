package camp.nextstep.edu.nextstep8.racing;

import java.util.List;
import java.util.Scanner;

public class RacingGameApplication {


    public static void main(String[] args) {
        RacingGameInput input = new RacingGameInput();

        String cars = input.getCars();
        int raceTimes = input.getRoundTimes();

        RacingGame racingGame = new RacingGame(cars, raceTimes);
        List<RacingEntry> record = racingGame.raceStart();

        RacingGameResultView resultView = new RacingGameResultView(record);
        resultView.showResult();
    }
}

