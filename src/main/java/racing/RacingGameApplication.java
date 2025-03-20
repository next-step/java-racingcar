package racing;

import racing.entity.RacingCars;
import racing.entity.RacingGame;
import racing.rule.RandomMoveRule;
import racing.view.RacingGameInputView;
import racing.view.RacingGameOutputView;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        // 레이싱 게임 입력
        RacingCars racingCars = RacingGameInputView.getCarsInput();
        int roundCount = RacingGameInputView.getRoundCountInput();
        RandomMoveRule randomMoveRule = new RandomMoveRule();

        // 레이싱 게임 진행
        RacingGame racingGame = new RacingGame(randomMoveRule);

        RacingGameOutputView.printHeadOfOutputMessage();
        for (int i = 0; i < roundCount; i++) {
            racingGame.playRound(racingCars);
            RacingGameOutputView.printRoundResult(racingCars);
        }

        // 우승자 발표
        List<String> winners = racingCars.getLeadingCarNameList();
        RacingGameOutputView.printRacingGameWinners(winners);
    }
}