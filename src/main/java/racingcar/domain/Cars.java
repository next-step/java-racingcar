package racingcar.domain;

import racingcar.controller.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    public static final String COMMA = ",";
    private List<Car> carList;

    public Cars(String carNameInput) {
        this.carList = new ArrayList<>();
        String[] carNameArr = carNameInput.split(COMMA);
        for (String carName : carNameArr) {
            carList.add(new Car(carName));
        }
    }

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void move(NumberGenerate numberGenerate) {
        for (Car car : carList) {
            car.move(numberGenerate.generate());
        }
    }

    public List<Car> findWinner() {
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

    public List<Car> getCars() {
        return this.carList;
    }

}
