package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for(String name : names){
            addCars(name);
        }
    }

    private void addCars(String carName) {
        cars.add(new Car(carName));
    }

    public void move(RandomNumber randomNumber) {
        this.cars.forEach(car -> car.move(randomNumber.isMove()));
    }

    public List<Car> selectWinners() {
        int winnerLocation = selectWinnerLocation();

        return this.cars.stream()
                .filter(car -> car.isSameLocation(winnerLocation))
                .collect(Collectors.toList());
    }

    private int selectWinnerLocation() {
        return this.cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt()
                ;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
