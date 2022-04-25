package racing;


import java.util.ArrayList;
import java.util.List;

public class Circuit {
    private static final int MAX_NUMBER_OF_CARS = 10;
    private static final int MIN_NUMBER_OF_CARS = 1;
    private static final int MAX_NUMBER_OF_MOVES = 10;
    private static final int MIN_NUMBER_OF_MOVES = 1;

    private final List<Car> cars;

    private final List<Car> winners;
    private final Integer totalRound;

    public Circuit(String[] carNames, int numberOfMoves) {
        if (carNames.length > MAX_NUMBER_OF_CARS || numberOfMoves > MAX_NUMBER_OF_MOVES
                || carNames.length < MIN_NUMBER_OF_CARS || numberOfMoves < MIN_NUMBER_OF_MOVES) {
            throw new IllegalArgumentException();
        }
        this.totalRound = numberOfMoves;
        Engine engine = new Engine();
        cars = createCars(carNames, engine, numberOfMoves);
        winners = new ArrayList<>();
    }

    private List<Car> createCars(String[] carNames, Engine engine, int numberOfMoves) {
        List<Car> createdCars = new ArrayList<>();
        for (String carName : carNames) {
            createdCars.add(new Car(carName.trim(), engine, numberOfMoves));
        }
        return createdCars;
    }

    public void startRacing() {
        for (Car car : cars) {
            car.racingStart();
        }
        findWinners(cars);
    }

    public String whoIsWinners() {
        StringBuilder winnersName = new StringBuilder(this.winners.get(0).getName());
        if (winners.size() == 1) {
            return winnersName.toString();
        }

        for (int i = 1; i < this.winners.size(); i++) {
            winnersName.append(", ").append(winners.get(i).getName());
        }

        return winnersName.toString();
    }

    private void findWinners(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            int carDistance = (int) car.getMoves().stream().filter(item -> item).count();
            if (carDistance > maxDistance) {
                maxDistance = carDistance;
            }
        }

        for (Car car : cars) {
            int carDistance = (int) car.getMoves().stream().filter(item -> item).count();
            if (carDistance == maxDistance) {
                this.winners.add(car);
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Integer getTotalRound() {
        return this.totalRound;
    }
}
