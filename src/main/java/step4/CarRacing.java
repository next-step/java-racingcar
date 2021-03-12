package step4;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class CarRacing {

    public static final int RANDOM_RANGE = 9;

    private List<Car> cars;

    public CarRacing(String[] drivers) {
        this.cars = IntStream.range(0, drivers.length)
                .mapToObj(i -> new Car(drivers[i]))
                .collect(Collectors.toList());
    }

    public List<Car> getWinner() {
        return cars.stream()
                .collect(groupingBy(car -> car.getPosition(), TreeMap::new, toList()))
                .lastEntry()
                .getValue();
    }

    public List<Car> getReady() {
        return cars;
    }

    public List<Car> getResults(Random random) {
        return cars.stream()
                .map(car -> {
                    move(random, car);
                    return car;
                }).collect(Collectors.toList());
    }

    private void move(Random random, Car car) {
        int randomNumber = getRandomNumber(random);
        car.move(randomNumber);
    }

    private int getRandomNumber(Random random) {
        return random.nextInt(RANDOM_RANGE);
    }


}
