package car_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return carsForGame;
    }

    public List<Car> findWinners() {
        int winnersPosition = findWinnersPosition();
        return findWinners(winnersPosition);
    }

    private List<Car> findWinners (int winnersPosition) {
        List<Car> winners = new ArrayList<>();
        for(Car car: carsForGame) {
            addWinners(winners, winnersPosition, car);
        }
        return winners;
    }

    // TODO: Argument 개수 줄이기
    private void addWinners(List<Car> winners, int winnerPosition, Car currCar) {
        if (currCar.isAtPosition(winnerPosition)) {
            winners.add(currCar);
        }
    }


    private int findWinnersPosition() {
        int maxPosition = -1;

        for(Car car : carsForGame) {
            maxPosition = findMaxPosition(car, maxPosition);
        }

        return maxPosition;
    }

    private int findMaxPosition(Car car, int currMaxPosition) {
        if (car.getPosition() > currMaxPosition) {
            currMaxPosition = car.getPosition();
        }
        return currMaxPosition;
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
