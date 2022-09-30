package racingcar;

import java.util.Scanner;

public class RacingCarApplication {

    public static void main(String[] args) {
        Integer carNumber = InputView.readInt("자동차 대수는 몇 대 인가요?");
        Integer tryCount = InputView.readInt("시도할 회수는 몇 회 인가요?");

        RacingGame racingGame = new RacingGame();
        racingGame.createCars(carNumber);

        ResultView.printFirstLine();
        for (int i = 0; i < tryCount; i++) {
            racingGame.tryGame();
            ResultView.printGameResult(racingGame.getCars());
        }
    }

}
