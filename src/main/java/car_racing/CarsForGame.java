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

    public CarsForGame() {
        this.carsForGame = new ArrayList<>();
    }

    /**
     * Test
     **/
    public CarsForGame(List<Car> carsForGame) {
        this.carsForGame = carsForGame;
    }

    private List<Car> createCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(NAME_DELIMITER);

        for (String name : names) {
            Name carName = new Name(name);
            Car car = new Car(carName);
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

    public List<String> getNames() {
        List<String> names = new ArrayList<>();

        for(Car car : carsForGame) {
            names.add(car.getStringName());
        }
        return names;
    }

    public void add(Car car) {
        carsForGame.add(car);
    }

    public List<Car> findWinners() {
        int winnersPosition = findWinnersPosition();
        return findWinners(winnersPosition);
    }

    // TODO: 들여쓰기 줄이기
    private List<Car> findWinners (int winnersPosition) {
        List<Car> winners = new ArrayList<>();
        for(Car car: carsForGame) {
            if (car.getPosition() == winnersPosition) {
                winners.add(car);
            }
        }
        return winners;
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
