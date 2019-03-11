package racing;

import java.util.HashMap;

public class RunRacingGame {
    public static void main(String[] args) {
        while (true) {
            try {
                RacingGame rg = new RacingGame();

                //사용자 입력값
                HashMap<String, String> userInputValue = RacingGameInputView.racingGameInput();
                //레이싱게임 초기값 설정
                rg.initRacingGame(Integer.parseInt(userInputValue.get("TIME")),Integer.parseInt(userInputValue.get("CAR_COUNT")));
                // 게임룰지정
                GameRule gameRule = new GameRule(true);
                //게임시작
                rg.runRacingGame(gameRule);
                //결과출력
                RacingGameResultVIew.racingResultView(rg);
            } catch (NumberFormatException e) {
                System.out.println("자동차대수 및 회수는 숫자만 입력가능합니다.");
                continue;
            }

            break;
        }
    }
}
