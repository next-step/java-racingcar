package carracing;

import carracing.car.Car;
import carracing.car.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private final Cars cars;
    private final int moveTryCount;
    private final CarsMoveStatusHistory carsMoveStatusHistory;

    public CarRacing(String[] carNames, int moveTryCount) {
        this.cars = this.createRaceCars(carNames);
        this.moveTryCount = moveTryCount;
        this.carsMoveStatusHistory = new CarsMoveStatusHistory();
    }

    private Cars createRaceCars(String[] carNames) {
        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public Cars getCars() {
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
            this.cars.move();
            this.carsMoveStatusHistory.save(this.cars);
        }
        ResultView.printCarRacingResult(this.carsMoveStatusHistory);
        ResultView.printCarRacingWinners(
                CarRacingWinners.findWinners(this.cars).get()
                        .stream()
                        .map(Car::getNameString)
                        .collect(Collectors.toList()));
    }
}
