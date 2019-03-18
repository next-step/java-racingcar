package racing;

public class RunningRacingGame {
    public static void main(String[] args) {
        UserInputValueObject inputValueObject;
        RacingGame racingGame;

        //사용자 입력값
        inputValueObject = RacingGameInputView.takeUserInput();
        //레이싱게임 초기화
        racingGame = new RacingGame(inputValueObject.getInputCarTime(),
                inputValueObject.getInputCarNames());

        //게임시작
        GameRule gameRule = new CarGameRuleUseRandomNumber();
        RacingGameResult racingGameResult = racingGame.runRacingGame(gameRule);

        //결과출력
        RacingGameResultView.raceResultView(racingGameResult);
    }
}
