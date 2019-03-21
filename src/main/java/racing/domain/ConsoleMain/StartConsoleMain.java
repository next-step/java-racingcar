package racing.domain.ConsoleMain;

import racing.CarGameRuleUseRandomNumber;
import racing.GameRule;
import racing.domain.RacingGame;
import racing.domain.RacingGameResult;
import racing.dto.UserInputValueObject;
import racing.view.consoleview.RacingGameInputView;
import racing.view.consoleview.RacingGameResultView;

public class StartConsoleMain {
    public static void main(String[] args) {
        //사용자 입력값
        UserInputValueObject inputValueObject = RacingGameInputView.takeUserInput();
        //레이싱게임 초기화
        RacingGame racingGame = new RacingGame(inputValueObject.getInputCarTime(),
                inputValueObject.getInputCarNames());

        //게임시작
        GameRule gameRule = new CarGameRuleUseRandomNumber();
        RacingGameResult racingGameResult = racingGame.runRacingGame(gameRule);

        //결과출력
        RacingGameResultView.raceResultView(racingGameResult);
    }
}