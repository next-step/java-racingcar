package step3.controller;

import step3.domain.Racing;
import step3.util.InputView;
import step3.util.ResultView;
import step3.util.Validator;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingController {

    private static final String SEPARATOR = ",";
    private ResultView resultView;
    private Racing racing;
    private int gameCount = 0;

    public RacingController() {
        resultView = new ResultView();
        racing = new Racing(new Random());
    }

    // 차 이름, 게임 횟수 입력 후 경기 준비(입력값 검증 및 Car 객체 생성)
    public void initGame() {
        // 입력
        InputView inputView = new InputView(new Scanner(System.in));
        String carNames = inputView.enterCarName();
        this.gameCount = inputView.enterGameCount();
        
        // 게임 횟수 검증
        Validator validator = new Validator();
        validator.checkGameCount(this.gameCount);

        racing.initRace(carNames);
    }

    // gameCount만큼 경기 진행, 거리 출력
    public void startRace() {
        // 게임 실행
        for(int i = 0; i < gameCount; i++) {
            racing.startRace();
            resultView.printDistance(racing.getCars());
            resultView.printNewLine();
        }
    }

    // 우승자 출력
    public void getWinner() {
        // 게임 결과 출력
        List<String> winners = racing.getWinner();
        resultView.printGameWinners(winners);
    }

}
