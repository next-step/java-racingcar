package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CarGroup {

    private final int RANDOM_MAX_INT_VALUE = 10;
    private List<Car> cars = new ArrayList<>();

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public CarGroup(String carNameData) {
        String[] carNames = carNameData.split(",");
        new CarCount(carNames.length);
        makeCars(carNames);
    }

    private void makeCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> racing() {
        Random random = new Random();
        for (Car car : cars) {
            car.move(random.nextInt(RANDOM_MAX_INT_VALUE));
        }
        return cars;
    }

    public List<String> getFarthestCarNames() {
        int farthestLocation = getFarthestLocation();
        List<String> farthestCarNames = new ArrayList<>();
        for (Car car : cars) {
            makeFarthestCarNames(farthestLocation, farthestCarNames, car);
        }
        return farthestCarNames;
    }

    private void makeFarthestCarNames(int farthestLocation, List<String> farthestCarNames, Car car) {
        if (car.isFarthestLocation(farthestLocation)) farthestCarNames.add(car.toString());
    }

    private int getFarthestLocation() {
        int farthestLocation = 0;
        for (Car car : cars) {
            farthestLocation = Math.max(farthestLocation, car.getLocation());
        }
        return farthestLocation;
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
