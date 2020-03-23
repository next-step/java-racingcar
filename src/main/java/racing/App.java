package racing;

import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String carNames = inputView.input("경주할 자동차 이름을 입력하세요(이름은 쉼표를(,) 기준으로 구분).");
        RacingGame racingGame = new RacingGame(carNames.split(","));

        int time = inputView.inputInt("시도할 회수는 몇 회 인가요?");

        System.out.println("실행 결과");

        for (int t = 0 ; t < time ; t++) {
            racingGame.move();
            resultView.printPositions(racingGame.getCars());
        }

        resultView.printWinner(racingGame.getWinners());
    }
}
