package step4;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    final Print print = new Print();
    private static final RacingRule racingRule = new RacingRule();

    public Racing(String[] carNames, int lapCount) {
        List<Car> cars = getCarReady(carNames);
        onRacing(cars, lapCount);
        print.winner(cars);
    }

    private List<Car> getCarReady(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
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
