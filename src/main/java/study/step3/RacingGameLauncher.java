package study.step3;

import java.util.List;

public class RacingGameLauncher {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames() ,InputView.inputTryTime());

        List<Round> rounds = RacingGameProgress.gameStart(racingGame, new RandomCarMoveCondition());

        Champion champion = new Champion(rounds);

        ResultView.racingResultPrint(rounds);
        ResultView.printChampion(champion.getChampitions());
    }
}
