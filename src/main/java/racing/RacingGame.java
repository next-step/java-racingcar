package racing;

import java.util.List;

public class RacingGame {

    private Cars cars;
    public RacingGame(int carCount) {
        this.cars = new Cars(RacingSupporter.generateCarList(carCount));
    }

    public void start(int opportunity) {
        for (int i = 0; i < opportunity; i++) {
            List<Integer> randomList = NumberGenerator.generateRandomList(cars.getCarList().size());
            RacingSupporter.raceCars(cars, randomList);

            RacingPrinter.drawPositions(cars.valueOfCarsPosition());
        }
    }
}
