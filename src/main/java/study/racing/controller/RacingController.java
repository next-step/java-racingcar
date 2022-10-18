package study.racing.controller;

import study.racing.domain.RacingGame;
import study.racing.domain.RacingRecord;
import study.racing.view.ResultView;
import study.racing.view.View;

public class RacingController {

    public static final String MESSAGE_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String MESSAGE_FOR_ROUND = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        // 입력
        View.outputView.println(MESSAGE_FOR_CAR_NAMES);
        String[] carNames = View.inputView.inputString().split(",");

        View.outputView.println(MESSAGE_FOR_ROUND);
        int round = View.inputView.inputInt();

        // 레이싱 게임 진행
        RacingGame racingGame = new RacingGame(carNames, round);
        racingGame.race();

        // 레이싱 결과 출력
        RacingRecord racingRecord = racingGame.getRacingRecord();
        ResultView.printResult(racingRecord);
        ResultView.printWinner(racingRecord);
    }
}
