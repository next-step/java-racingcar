package study.racing.controller;

import study.racing.domain.RacingGame;
import study.racing.domain.RacingRecord;
import study.racing.util.View;
import study.racing.view.ResultView;

public class RacingController {

    public static void main(String[] args) {
        // 입력
        View.outputView.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = View.inputView.inputString().split(",");

        View.outputView.println("시도할 회수는 몇 회 인가요?");
        final int loopCount = View.inputView.inputInt();

        // 레이싱 게임 진행
        RacingGame racingGame = new RacingGame();
        racingGame.participate(carNames);
        racingGame.race(loopCount);

        // 레이싱 결과 출력
        RacingRecord racingRecord = racingGame.getRacingRecord();
        ResultView.printResult(racingRecord);
        ResultView.printWinner(racingRecord);
    }
}
