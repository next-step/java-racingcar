package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    protected void move() {
        for (Car car : carList) {
            car.move(RacingCar.getRandom());
        }
    }

    List<Car> findWinner() {
        int maxDistance = getMaxDistance(this.carList);

        return carList.stream().filter(car -> car.distance().matchDistance(maxDistance)).collect(Collectors.toList());
    }

    static int getMaxDistance(List<Car> carList) {
        int maxDistance = 0;
        for (Car car : carList) {
            maxDistance = car.distance().max(maxDistance);
        }

        return maxDistance;
    }

    List<Car> Cars() {
        return this.carList;
    }

}
