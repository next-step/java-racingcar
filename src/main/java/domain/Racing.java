package domain;

import java.util.List;

public class Racing {

    private Winners winners;

    public Racing(List<CarName> carNames) { winners = makeCar(carNames); }

    private Winners makeCar(List<CarName> carNames) {
        return new Winners(carNames);
    }

    public void race(MovingStrategy movingStrategy) {
        for (Car car : winners.getCars()) {
            car.move(movingStrategy.isMovable(movingStrategy.getIntValue()));
        }
    }

    public List<Car> getCars() {
        return winners.getCars();
    }

    public List<String> getWinners() {
        return winners.getWinners();
    }
}
