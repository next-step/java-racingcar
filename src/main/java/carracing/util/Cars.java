package carracing.util;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Car get(int index) {
        return this.carList.get(index);
    }

    public List<Car> getCars() {
        return this.carList;
    }

    public List<Car> getWinner(RaceResult raceResult) {
        return this.carList.stream()
                .filter(car -> car.getDrivingHistory() == raceResult.maximumDistance)
                .collect(Collectors.toList());
    }

}
