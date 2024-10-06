package carracing;

import carracing.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRacing {
    private static final Random RANDOM = new Random();
    private final List<Car> cars;
    private final int moveTryCount;
    private final CarsMoveStatusHistory carsMoveStatusHistory;

    public CarRacing(String[] carNames, int moveTryCount) {
        this.cars = this.createRaceCars(carNames);
        this.moveTryCount = moveTryCount;
        this.carsMoveStatusHistory = new CarsMoveStatusHistory();
    }

    private List<Car> createRaceCars(String[] carNames) {
        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMoveTryCount() {
        return moveTryCount;
    }

    public CarsMoveStatusHistory getCarsMoveStatusHistory() {
        return carsMoveStatusHistory;
    }

    public void start() {
        for (int i = 0; i < this.moveTryCount; i++) {
            this.moveCarsWithRandom();
            this.carsMoveStatusHistory.save(this.cars);
        }
        ResultView.printCarRacingResult(this.carsMoveStatusHistory);
        ResultView.printCarRacingWinners(CarRacingWinners.findWinners(cars)
                        .stream()
                        .map(Car::getCarNameString)
                        .collect(Collectors.toList()));
    }

    private void moveCarsWithRandom() {
        for (Car car : this.cars) {
            car.move(RANDOM.nextInt(10));
        }
    }
}
