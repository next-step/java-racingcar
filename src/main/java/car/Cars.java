package car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int START_DISTANCE = 0;
    private static final int GREATER_THAN_WINNER = 0;
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(START_DISTANCE, carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTotalCarCount() {
        return cars.size();
    }

    public void playGameByCars(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int randomNumber = randomNumbers.get(i);
            car.game(randomNumber);
        }
    }

    public List<String> findTiedWinnerCarNames() {
        Car winnerCar = findFinalWinner();
        return cars.stream()
                .filter(car -> car.isSameDistance(winnerCar))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private Car findFinalWinner() {
        Car winnerCar = cars.get(0); //todo stream을 안 쓰고, 개선의 여지가 있을지 고민.
        for (Car car : cars) {
            winnerCar = changeWinnerCar(winnerCar, car);
        }
        return winnerCar;
    }

    private Car changeWinnerCar(Car winnerCar, Car car) {
        if (car.compareToDistance(winnerCar) > GREATER_THAN_WINNER) {
            return car;
        }
        return winnerCar;
    }
}
