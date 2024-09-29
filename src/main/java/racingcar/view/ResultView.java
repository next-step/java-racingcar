package racingcar.view;

import racingcar.RacingGame;
import racingcar.util.RandomNumberGenerator;

public class ResultView {
    private final int carNumber;
    private final int movement;

    public ResultView(int carNumber, int movement) {
        this.carNumber = carNumber;
        this.movement = movement;
    }

    public void print() {
        System.out.println();
        System.out.println("실행 결과");
        RacingGame racingGame = new RacingGame(carNumber, movement);
        System.out.println(racingGame.runAndResult(new RandomNumberGenerator()));
    }
}
