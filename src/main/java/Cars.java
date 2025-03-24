import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = new ArrayList<>(cars);
    }

    public static Cars fromNames(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    private void validateCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 목록이 비어있습니다.");
        }
    }

    public List<CarStatus> getCarStatuses() {
        List<CarStatus> statuses = new ArrayList<>();
        for (Car car : cars) {
            statuses.add(new CarStatus(car));
        }
        return statuses;
    }

    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy.shouldMove());
        }
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<CarStatus> findWinners() {
        int maxPosition = findMaxPosition();
        List<CarStatus> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(new CarStatus(car));
            }
        }
        return winners;
    }
}
