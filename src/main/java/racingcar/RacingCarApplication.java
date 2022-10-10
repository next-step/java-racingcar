package racingcar;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        List<String> carNames = InputView.readStringList("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", ",");
        int tryCount = InputView.readInt("시도할 회수는 몇 회 인가요?");

        Cars cars = Cars.createCarsByNames(carNames);
        RacingGame racingGame = new RacingGame(cars);

        ResultView.printFirstLine();
        for (int i = 0; i < tryCount; i++) {
            racingGame.tryGame();
            ResultView.printGameResult(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinnerNames());
    }

}
