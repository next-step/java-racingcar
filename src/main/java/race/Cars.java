package race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.createCar(carName, new ArrayList<Boolean>()));
        }
        return new Cars(cars);
    }
    protected final List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    protected Cars moveCars(MoveCondition moveCondition) {
        for (int i = 0; i < this.getCars().size(); i++) {
            this.getCars().get(i).addDistance(moveCondition);
        }
        return this;
    }

    protected List<Car> getWinner() {
        int max = getMaxDistance();
        return cars.stream()
                .filter(c -> c.distance() >= max)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
                .map(Car::distance)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).get(0);
    }

}
