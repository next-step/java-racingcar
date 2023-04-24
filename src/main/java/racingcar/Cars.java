package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public Cars() {

    }

    public void move() {
        for (Car car : cars) {
            if (car.moveable(RacingRandom.getRandomNo())) {
                car.move();
            }
        }
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        int max = getHighDistance(cars);
        for (Car car : cars) {
            if(car.isWinner(max)){
                winners.add(car);
            }
        }
        return winners;
    }

    private int getHighDistance(List<Car> cars) {
        int max = 1;
        for (Car car : cars) {
            max = car.max(max);
        }
        return max;
    }

    public List<Car> getCars() {
        return cars;
    }


}
