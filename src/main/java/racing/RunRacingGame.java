package racing;

import java.util.HashMap;

public class RunRacingGame {
    public static void main(String[] args) {
        UserInputValueObject inputValueObject;
        RacingGame rg;

        while (true) {
            try {
                //사용자 입력값
                inputValueObject = RacingGameInputView.racingGameInput();
                //레이싱게임 초기화
                rg = new RacingGame(Integer.parseInt(inputValueObject.getInputCarTime()),
                        Integer.parseInt(inputValueObject.getInputCarCount()));
            } catch (NumberFormatException e) {
                System.out.println("자동차대수 및 회수는 숫자만 입력가능합니다.");
                continue;
            }
            break;
        }

        // 게임룰지정
        GameRule gameRule = new CarGameRuleUseRandomNumber();
        //게임시작
        rg.runRacingGame(gameRule);
        //결과출력
        RacingGameResultVIew.racingResultView(rg.racingGameResult());
    }
}
