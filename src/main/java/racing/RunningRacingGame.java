package racing;

public class RunningRacingGame {
    public static void main(String[] args) {
        UserInputValueObject inputValueObject;
        RacingGame rg;

        //사용자 입력값
        inputValueObject = RacingGameInputView.racingGameInput();
        //레이싱게임 초기화
        rg = new RacingGame(inputValueObject.getInputCarTime(),
                inputValueObject.getInputCarNames());

        //게임시작
        GameRule gameRule = new CarGameRuleUseRandomNumber();
        rg.runRacingGame(gameRule);

        //결과출력
        RacingGameResultView.racingResultView(rg);
    }
}
