package racingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNames) {
        this.cars = new ArrayList<>();
        String[] sCars = carNames.split(",");
        for (String sCar : sCars) {
            cars.add(new Car().createCar(sCar));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void playGame() {
        for (Car car : this.cars) {
            car.play(new Random());
        }
    }

    public List<String> getWinners() {
        int maxPos = getMaxPos();

        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPos() == maxPos)
                .forEach(car -> winners.add(car.getName()));

        return winners;
    }

    private int getMaxPos() {
        Collections.sort(getCars());
        int maxPos = getCars().get(0).getPos();
        return maxPos;
    }

}
