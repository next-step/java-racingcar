
package step3;

import java.awt.print.Printable;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private int roundCount;

    public RacingGame(List<String> carNameList, int roundCount) {
        this.roundCount = roundCount;
        this.cars = new Cars(carNameList);
    }

    public void play() {
        for (int i = 0; i < roundCount; i++) {
            cars.play();
            System.out.println(cars.getWayResult());
        }
    }

    public MatchResult getMatchResult() {
        return new MatchResult(cars.getWinners());
    }

}