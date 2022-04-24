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

    public Circuit(String[] carNames, int numberOfMoves) {

        if (carNames.length > MAX_NUMBER_OF_CARS || numberOfMoves > MAX_NUMBER_OF_MOVES
                || carNames.length < MIN_NUMBER_OF_CARS || numberOfMoves < MIN_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException();
        }
        this.totalRound = numberOfMoves;
        Engine engine = new Engine();
        cars = createCars(engine, carNames, numberOfMoves);
    }

    private List<Car> createCars(Engine engine, String[] carNames, int numberOfMoves) {
        List<Car> createdCars = new ArrayList<>();
        for (String carName : carNames) {
            createdCars.add(new Car(carName, engine, numberOfMoves));
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
