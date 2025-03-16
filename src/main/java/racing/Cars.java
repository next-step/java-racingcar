package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void race() {
        for (Car car : cars) {
            car.race();
        }
    }

    public void race(int tryCount) {
        ResultView.printTitle();

        for (int i = 0; i < tryCount; i++) {
            ResultView.printTryCount(i + 1);
            race();
            ResultView.printCars(this);
        }
    }

    public List<String> getPositionStrings() {
        List<String> positionStrings = new ArrayList<>();
        for (Car car : cars) {
            positionStrings.add(car.getPositionString());
        }
        return positionStrings;
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
