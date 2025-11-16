package racinggame.model.car;

import static racinggame.RandomNumberBox.getRandomNumber;
import static racinggame.ui.MC.printGameStates;

import java.util.ArrayList;
import java.util.List;
import racinggame.model.move.MoveStrategy;
import racinggame.model.move.RandomMoveStrategy;
import racinggame.model.position.Position;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createByNames(List<String> carNames) {
        List<Car> carList = new ArrayList<>(carNames.size());

        for (String carName : carNames) {
            carList.add(
                    new Car(carName)
            );
        }

        return new Cars(carList);
    }

    public int size() {
        return this.cars.size();
    }

    public void playPerRound(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
            printGameStates(car);
        }
    }

    public Position findMaxPositions() {
        Position max = new Position();
        for (Car car : cars) {
            max = car.compareAndChangeIfMax(max);
        }

        return max;
    }

    public List<CarName> findWinners(Position maxPositions) {
        List<CarName> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.addAll(
                    judgeCarHasMax(maxPositions, car)
            );
        }

        return winners;
    }

    private List<CarName> judgeCarHasMax(
            final Position maxPositions,
            final Car car
    ) {
        if (!car.isSamePosition(maxPositions)) {
            return new ArrayList<>();
        }

        return List.of(car.name());
    }
}
