package carracing.util;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void add(Car car) {
        this.carList.add(car);
    }

    public Car get(int index) {
        return this.carList.get(index);
    }

    public List<Car> getCars() {
        return this.carList;
    }

    public List<String> getWinner(RaceResult raceResult) {
        List<String> winnerCarNames = new ArrayList<>();
        for (Car car : this.carList) {
            findWinner(winnerCarNames, car, raceResult);
        }
        return winnerCarNames;
    }

    private void findWinner(List<String> winnerCarNames, Car car, RaceResult raceResult) {
        if (car.getDrivingHistory() == raceResult.maximumDistance) {
            winnerCarNames.add(car.getName().getAlias());
        }
    }
}
