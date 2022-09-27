package racingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(int n) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public Cars createCars(String carNames) {
        String[] sCars = carNames.split(",");
        for (String sCar : sCars) {
            cars.add(new Car().createCar(sCar));
        }
        return this;
    }

    public void playGame() {
        for (Car car : this.cars) {
            car.play(new Random());
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        Collections.sort(getCars());
        int maxPos = getCars().get(0).getPos();
        for (Car car : cars) {
            if (maxPos > car.getPos()) break;
            winners.add(car.getName());
        }

        return winners;
    }

}
