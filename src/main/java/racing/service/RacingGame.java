package racing.service;

import racing.domain.car.Cars;
import racing.domain.fuel.Fuel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Service
public class RacingGame {
    public static RacingGame getInstance() {
        return InnerClazz.racingGame;
    }

    private void validateCars(Cars cars) {
        if (Objects.isNull(cars) || cars.isEmpty())
            throw new IllegalArgumentException("경기를 진행할 차가 없습니다.");
    }

    private void validateTurnSize(int turnSize) {
        if (turnSize < 1)
            throw new IllegalArgumentException("경기를 진행할 횟수가 1보다 작습니다.");
    }

    public List<Cars> racingAll(Cars cars, int turnSize, Fuel fuel) {
        validateCars(cars);
        validateTurnSize(turnSize);

        List<Cars> carsList = new ArrayList<>();
        for (int i = 0; i < turnSize; i++) {
            cars = cars.moveAll(fuel);
            carsList.add(cars);
        }
        return carsList;
    }

    private static class InnerClazz {
        private static RacingGame racingGame = new RacingGame();
    }
}
