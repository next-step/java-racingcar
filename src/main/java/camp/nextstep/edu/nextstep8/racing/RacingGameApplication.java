package camp.nextstep.edu.nextstep8.racing;

import java.util.List;
import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) {
        int carNumbers = ConsoleInputHelper.getValue("참가할 자동차는 몇 대 인가요?", Scanner::nextInt);
        int raceTimes = ConsoleInputHelper.getValue("시도할 횟수는 몇 회 인가요?", Scanner::nextInt);

        RacingGame racingGame = new RacingGame(carNumbers, raceTimes);
        List<Integer> result = racingGame.raceStart();

        RacingGameResultView resultView = new RacingGameResultView(result, carNumbers, raceTimes);
        resultView.showResult();
    }
}

