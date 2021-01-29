
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

    public RacingWinners playAndGetWinners() {
        for (int i = 0; i < roundCount; i++) {
            System.out.println(cars.playAndGetResult());
        }
        return new RacingWinners(cars.getWinners());
    }

}