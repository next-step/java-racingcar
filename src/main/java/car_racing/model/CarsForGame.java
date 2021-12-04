package car_racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarsForGame {

    private static final String NAME_DELIMITER = ",";

    private final List<Car> carsForGame;

    public CarsForGame(String names) {
        this.carsForGame = createCars(names);
    }

    public CarsForGame(List<Car> carsForGame) {
        /* Test */
        this.carsForGame = carsForGame;
    }

    public CarsForGame() {
        this.carsForGame = new ArrayList<>();
    }

    private List<Car> createCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(NAME_DELIMITER);

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public void playOneRound(MoveStrategy moveStrategy) {
        for (Car car : carsForGame) {
            boolean ableToMove = moveStrategy.decideToMove();
            car.move(ableToMove);
        }
    }

    public List<Car> getCars() {
        return carsForGame;
    }

    public List<Car> findWinners() {
        Position winnersPosition = findWinnersPosition();
        return findWinners(winnersPosition);
    }

    private List<Car> findWinners (Position winnerPosition) {
        return carsForGame.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }

    private Position findWinnersPosition() {
        Position maxPosition = new Position(-1);

        for(Car car : carsForGame) {
            maxPosition = car.findMaxPosition(maxPosition);
        }

        return maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarsForGame carsForGame = (CarsForGame) o;
        return Objects.equals(this.carsForGame, carsForGame.carsForGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsForGame);
    }

}
