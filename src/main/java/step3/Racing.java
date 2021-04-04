package step3;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    final Print print = new Print();
    private static final RacingRule racingRule = new RacingRule();

    public Racing(int carCount, int lapCount) {
        List<Car> cars = getCarReady(carCount);
        onRacing(cars, lapCount);
    }

    private List<Car> getCarReady(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void onRacing(List<Car> cars, int lapCount) {
        print.startLap();
        racingRule.goCars(cars);
        print.racing(cars);
        lapCount--;
        if (lapCount > 0) {
            onRacing(cars, lapCount);
        }
    }

}
