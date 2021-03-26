package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<Car> winners;

    public Winner() {
        winners = new ArrayList<>();
    }

    public List<Car> findWinner(List<Car> carList) {
        return findWinner(carList, getMaxPostion(carList));
    }

    private Position getMaxPostion(List<Car> carList) {
        Position maxPosition = new Position();
        for (Car car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> findWinner(List<Car> carList, Position maxPosition) {
        for (Car car : carList) {
            setWinner(car, maxPosition);
        }
        return winners;
    }

    private void setWinner(Car car, Position maxPosition) {
        if (maxPosition.isZero()) {
            return;
        }
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }
}
