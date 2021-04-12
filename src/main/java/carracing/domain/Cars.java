package carracing.domain;

import carracing.util.RandomUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        Arrays.stream(carNames).forEach(name -> this.cars.add(new Car(name)));
    }

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void play() {
        cars.stream().forEach(car -> car.move(RandomUtil.randomNumber()));
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.isWinner(getMaxScore()))
                .map(Car::getName)
                .map(Name::getName)
                .collect(Collectors.toList());
    }

    private int getMaxScore() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(0, Math::max);

    }
}
