package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private static final int RANGE_FOR_RANDOM = 10;
    private final List<Car> cars;
    private Random random = new Random();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] carNames) {
        cars = new ArrayList(carNames.length);

        for(String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for(Car car :cars) {
            car.move(getRandomInt());
        }
    }

    int getRandomInt() throws IllegalArgumentException {
        return random.nextInt(RANGE_FOR_RANDOM);
    }

    List<Car> asList() {
        return listDeepCopy(cars);
    }

    private List<Car> listDeepCopy(List<Car> cars) {
        ArrayList<Car> carsDeepCopy = new ArrayList<>(cars.size());
        for(Car car : cars) {
            carsDeepCopy.add(car.copy());
        }
        return carsDeepCopy;
    }

    ArrayList<Name> findWinnerNames() {
        Position carMaxPosition = findCarMaxPosition();
        return findWinnerNames(carMaxPosition);
    }

    Position findCarMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            if(car.isBiggerPosition(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    ArrayList<Name> findWinnerNames(Position maxPosition) {
        ArrayList<Name> winnerNames = new ArrayList<>();

        for (Car car : cars) {
            if (!car.samePosition(maxPosition)) {
                continue;
            }
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

}
