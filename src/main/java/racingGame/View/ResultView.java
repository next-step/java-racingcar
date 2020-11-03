package racingGame.View;

import racingGame.Car;
import racingGame.Cars;
import racingGame.GameSetting;
import racingGame.ScoreGenerator;

import java.util.List;

public class ResultView {

    final private Cars cars;
    final private ScoreGenerator scoreGenerator;

    private ResultView(ScoreGenerator scoreGenerator, GameSetting gameSetting) {
        this.cars = Cars.of(gameSetting.getNumCar());
        this.scoreGenerator = scoreGenerator;
    }

    public static ResultView of(GameSetting gameSetting) {
        ScoreGenerator scoreGenerator = new ScoreGenerator();
        return new ResultView(scoreGenerator, gameSetting);
    }

    public void processRound() {
        cars.moves(scoreGenerator);
    }

    public void printStatus() {
        List<Integer> positions = cars.getPositions();

        for (Integer position : positions) {
            printDash(position);
        }
        System.out.println();
    }

    private void printDash(int numDash) {
        for (int i = 0; i < numDash; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
