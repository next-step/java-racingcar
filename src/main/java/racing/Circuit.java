package racing;


import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private static final int MAX_NUMBER_OF_CARS = 10;
    private static final int MIN_NUMBER_OF_CARS = 1;
    private static final int MAX_NUMBER_OF_MOVES = 10;
    private static final int MIN_NUMBER_OF_MOVES = 1;

    private final List<Car> cars;
    private final Integer totalRound;

    public Circuit(int numberOfCars, int numberOfMoves) {
        if (numberOfCars > MAX_NUMBER_OF_CARS || numberOfMoves > MAX_NUMBER_OF_MOVES
                || numberOfCars < MIN_NUMBER_OF_CARS || numberOfMoves < MIN_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException();
        }
        this.totalRound = numberOfMoves;
        Engine engine = new Engine();
        cars = createCars(engine, numberOfCars, numberOfMoves);
    }

    private List<Car> createCars(Engine engine, int numberOfCar, int numberOfMoves) {
        List<Car> createdCars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            createdCars.add(new Car(engine, numberOfMoves));
        }
        return createdCars;
    }

    public void startRacing() {
        for (Car car : cars) {
            car.racingStart();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Integer getTotalRound() {
        return this.totalRound;
    }
}
