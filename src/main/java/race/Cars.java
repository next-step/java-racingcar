package race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    protected List<String> getWinner() {

        int max = getMaxDistance();
        List<String> winners = new ArrayList<>();
        for (Car car :cars) {
            addWinners(car, max, winners);
        }

        return winners;
    }

    private int getMaxDistance() {
        List<Integer> distances = new ArrayList<>();
//        for (Car c : cars) {
//            distances.add(c.getDistance());
//        }
        distances.sort(Collections.reverseOrder());
        return distances.get(0);
    }

    private List<String> addWinners(Car car, int max, List<String> winners) {
//        if (car.getDistance() >= max)
//            winners.add(car.getName());
        return winners;
    }

}
