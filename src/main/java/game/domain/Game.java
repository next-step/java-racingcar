package game.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final NumberGenerator generator;
    private final List<Car> cars;

    public Game(NumberGenerator generator, List<Car> cars) {
        this.generator = generator;
        this.cars = cars;
    }

    public void play() {
        for (Car car : cars) {
            int number = generator.getNumber();
            car.move(number);
        }
    }

    public List<Integer> getDistances(){
        return cars.stream().map(Car::getDistance).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        int maxDistance = calcMaxDistance();
        return getWinner(maxDistance);
    }

    private int calcMaxDistance() {
        int maxDistance = 0;
        for(Car car : cars){
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    private List<Car> getWinner(int maxDistance) {
        return cars.stream().filter(car -> {
            return car.getDistance() == maxDistance;
        }).collect(Collectors.toList());
    }
}
