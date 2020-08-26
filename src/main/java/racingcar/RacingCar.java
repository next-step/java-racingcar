package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static Cars cars;
    private final RandomMove randomMove;

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
            isCarNameLength(names[i]);
            cars.add(new Car(names[i]));
        }

        return new Cars(cars);
    }

    private void isCarNameLength(String input) {
        if(input.length() > 5) {
            throw new IllegalArgumentException("차 이름은 5자 이하로만 이뤄질 수 있습니다.");
        }
    }

    private String[] splitName(String carNames) {
        return carNames.split(",");
    }

    public List<Car> getCarList() {
        return cars.getCar();
    }

}
