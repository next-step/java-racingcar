package race;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public CarRace(String[] carNames, int tryCount, ForwardCheck forwardCheck) {
        this.tryCount = tryCount;
        initCar(carNames, forwardCheck);
    }

    public List<Car> proceedRound() {
        proceed();
        tryCount--;
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean checkTryCount() {
        return tryCount > 0;
    }

    public List<String> getRaceResult() {
        List<String> raceResult = new ArrayList<>();

        List<Car> cars = getCars();
        int size = cars.size();

        int maxPosition = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            maxPosition = compareMaxPosition(cars, i, maxPosition);
        }

        for (Car car : cars) {
            collectWinners(car, maxPosition, raceResult);
        }

        return raceResult;
    }

    private void initCar(String[] carNames, ForwardCheck forwardCheck) {
        int carCount = carNames.length;
        for(int i = 0; i < carCount; i++) {
            this.cars.add(new Car(carNames[i], forwardCheck));
        }
    }

    private void proceed() {
        for (Car car : cars) {
            car.forward();
        }
    }

    private void collectWinners(Car car, int maxPosition, List<String> raceResult) {
        if (car.getForwardResult() == maxPosition) {
            raceResult.add(car.getCarName());
        }
    }

    private int compareMaxPosition(List<Car> cars, int index, int maxPosition) {
        if (cars.get(index).getForwardResult() > maxPosition) {
            maxPosition = cars.get(index).getForwardResult();
        }
        return maxPosition;
    }
}
