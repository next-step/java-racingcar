package basicgame;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static List<Car> cars;
    private final static int MAX_RANDOM = 10;

    public void activeCar() {
        for (Car car : cars) {
            car.go(RandomUtil.getRandomValue(MAX_RANDOM));
        }
    }

    public void initCar(String[] carNameList) {
        cars = new ArrayList<>();
        for (String s : carNameList) {
            cars.add(new Car(s));
        }
    }

    public int carsSize() {
        return cars.size();
    }

    public List<Vehicle> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> mostDistance(){
        Map<Integer, List<Car>> carList = cars.stream()
                .collect(Collectors.groupingBy(Car::getDistance, Collectors.toList()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .limit(1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return carList.entrySet().iterator().next().getValue();
    }
}
