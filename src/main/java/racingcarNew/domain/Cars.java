package racingcarNew.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private int winnerMoveCount;
    private List<Car> cars;

    public Cars(List<Car> cars, int winnerMoveCount) {
        this.cars = cars;
        this.winnerMoveCount = winnerMoveCount;
    }

    public Cars moveAll() {
        List<Car> carHistory = new ArrayList<>();
        for (Car car : cars) {
            int carMoveCount = car.move(Utils.getRandomNo());
            Car movedCar = new Car(car.getCarName(), carMoveCount);
            checkWinnerMoveCount(carMoveCount);
            carHistory.add(movedCar);
        }
        return new Cars(carHistory, winnerMoveCount);
    }

    private void checkWinnerMoveCount(int carMoveCount) {
        if (this.winnerMoveCount < carMoveCount) {
            this.winnerMoveCount = carMoveCount;
        }
    }

    public List<Car> getWinners() {
        return cars.stream().filter(car -> car.isWinner(this.winnerMoveCount)).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
