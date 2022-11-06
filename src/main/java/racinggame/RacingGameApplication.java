package racinggame;

import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameApplication {
    public static void main(String[] args) {
        String[] carNames = InputView.requestCarName("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int reps = InputView.requestNumber("시도할 회수는 몇 회인가요?");
        System.out.println("실행 결과");

        RacingGame racingGame = new RacingGame(carNames, reps);

        while(!racingGame.isFinished()){
            racingGame.race();
            ResultView.printRacingResult(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());

    }
}
