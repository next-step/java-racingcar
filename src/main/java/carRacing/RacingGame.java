package carRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RacingGame {

    private final List<Car> carList;
    private final int trialCount;

    public RacingGame(int carCount, int trialCount) {
        this.carList = cars(carCount);
        this.trialCount = trialCount;
    }

    public void gameStart() {
        for (Car car : carList) {
            car.move(trialCount);
            System.out.println(car.position());
        }
    }

    private List<Car> cars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }

        return carList;
    }

}
