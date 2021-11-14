package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CarGroup {

    private final int RANDOM_MAX_INT_VALUE = 10;
    private List<Car> cars = new ArrayList<>();

    public CarGroup(String message) {
        String[] carNames = message.split(",");
        if (carNames.length < 1) {
            throw new IllegalArgumentException("자동차 대수는 1이상이여야 합니다.");
        }
        makeCars(carNames);
    }

    private void makeCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void racing() {
        Random random = new Random();
        for (Car car : cars) {
            car.move(random.nextInt(RANDOM_MAX_INT_VALUE));
        }
        ResultView.result(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarGroup)) return false;
        CarGroup carGroup = (CarGroup) o;
        return cars.equals(carGroup.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
