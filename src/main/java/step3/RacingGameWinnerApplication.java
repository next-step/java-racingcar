package step3;

import java.util.HashMap;
import java.util.Map;

class RacingGameWinnerApplication {

    private InputView input;

    protected RacingGameWinnerApplication() {
        this.input = new InputView();
    }

    public static void main(String[] args) {

        RacingGameWinnerApplication app = new RacingGameWinnerApplication();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] playerName = app.input.inputPlayerName();
        int carNumber = app.input.inputCarNumber();
        int tryCount = app.input.inputTryCount();

        RacingGameWinner racingGameWinner = new RacingGameWinner();
         Map<String, Integer > racingScore = racingGameWinner.connectPlayerToCar(playerName, carNumber);
        // 유효성 체크는 InputView에서 했으므로 PASS(Player 수와 차 대수가 동일한지)
//        racingScore = racingGameWinner.connectPlayerToCar(playerName, carNumber);

//        racingGameWinner.setInitPosition(carNumber); => Map초기화 시, 같이 초기화 되서 괜춘

        System.out.println("실행결과");

        while (tryCount-- > 0) {
            racingGameWinner.startRacingToSelectCar(racingScore);
            racingGameWinner.resultView();
        }
    }
}
