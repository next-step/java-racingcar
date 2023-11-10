package racewinner.domain;

import racewinner.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car: cars) {
            car.move(moveStrategy.number());
        }
    }

    public List<String> findWinner() {
        return getWinnerList(getMaxPosition());
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    private List<String> getWinnerList(Position position) {
        final List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            addWinner(position, winnerList, car);
        }

        return winnerList;
    }

    private void addWinner(Position position, List<String> winnerList, Car car) {
        if (car.isWinner(position)) {
            winnerList.add(car.name());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car: cars) {
            stringBuilder.append(car.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
