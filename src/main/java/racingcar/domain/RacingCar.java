package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static Cars cars;
    private final RandomMove randomMove;
    private final static String SplitText = ",";

    public RacingCar(String carName, RandomMove randomMove) {
        this.cars = carReady(carName);
        this.randomMove = randomMove;
    }

    public void racingPlay() {
        cars.move(randomMove);
    }

    public Cars carReady(String carName) {
        List<Car> cars = new ArrayList<>();

        String[] names = splitName(carName);
        for(int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        return new Cars(cars);
    }

    private String[] splitName(String carNames) {
        return carNames.split(SplitText);
    }

    public List<Car> getCarList() {
        return cars.getCar();
    }

}
