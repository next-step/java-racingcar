package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private int winnerScore;

    public Cars(String carList) {
        String[] carNames = carList.split(",");

        for (String car : carNames) {
            cars.add(new Car(car));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void play() {
        for (Car car : cars) {
            car.isMove(new RandomMovingStrategy());
            if(winnerScore < car.getDistance()){
                winnerScore = car.getDistance();
            }
        }
    }

    public List<Car> isWinners() {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if(car.getDistance() == winnerScore){
                winnerCars.add(car);
            }
        }
        return Collections.unmodifiableList(winnerCars);
    }
}
