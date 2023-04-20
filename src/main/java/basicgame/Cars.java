package basicgame;

import java.util.Comparator;
import java.util.stream.Collectors;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public void activeCar(int randomValue) {
        for (Car car : cars) {
            car.go(randomValue);
        }
    }

    public void initCar(String[] carNameList) {
        cars = new ArrayList<>();
        for (String s : carNameList) {
            addCar(s, 1);
        }
    }

    public void addCar(String carName, int distance){
        cars.add(Car.newInstance(carName,distance));
    }

    public int carsSize() {
        return cars.size();
    }

    public List<Vehicle> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinner() {
        int mostDistance = getMostDistance();
        return cars.stream()
                .filter(t -> t.getDistance() == mostDistance)
                .collect(Collectors.toList());
    }

    public Integer getMostDistance() {
        return cars.stream()
                .map(Car::getDistance)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }
}
