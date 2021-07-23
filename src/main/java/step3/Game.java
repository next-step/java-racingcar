package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private int numberOfCars;
    private int numberOfTurns;
    private int currentTurn = 0;

    private List<Car> cars;

    public Game() { }

    public Game(int numberOfCars, int numberOfTurns) {
        this.numberOfCars = numberOfCars;
        this.numberOfTurns = numberOfTurns;

        this.cars = Stream.generate(Car::new)
                .limit(this.numberOfCars)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() { return this.cars.subList(0, cars.size()); }

    private MOVE goOrStop() { return MOVE.fromInt(LuckyNumberGenerator.getRandomInt()); }

    private void nextTurn() {
        cars.stream().filter(x -> goOrStop().equals(MOVE.GO))
                .forEach(Car::progress);

        this.currentTurn += 1;
    }
}
