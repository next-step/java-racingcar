package basicgame;

import basicgame.strategy.ActiveStrategy;

import java.util.Comparator;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final static int MAX_RANDOM = 10;
    private List<Car> cars;


    public void activeCar(ActiveStrategy activeStrategy) {
        for (Car car : cars) {
            car.go(activeStrategy.generateRandom(MAX_RANDOM));
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

    public List<String> getWinners() {
        int mostDistance = getMostDistance();
        return cars.stream()
                .filter(t -> t.isEqualDistance(mostDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Integer getMostDistance() {
        return cars.stream()
                .map(Car::getDistance)
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NullPointerException("Car 등록이 되어있지 않습니다."));
    }
}
