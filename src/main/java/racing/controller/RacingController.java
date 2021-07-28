package racing.controller;

import racing.domain.car.Cars;
import racing.domain.dto.GameResponse;
import racing.domain.fuel.Fuel;
import racing.domain.fuel.RandomFuel;
import racing.domain.dto.GameRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public final class RacingController {
    private RacingController() {}

    public static RacingController getInstance() {
        return InnerClazz.instance;
    }

    public GameResponse gameRun(GameRequest gameRequest) {
        Fuel fuel = new RandomFuel();
        Cars cars = gameRequest.cars();
        int turnSize = gameRequest.turnSize();

        validateCars(cars);
        validateTurnSize(turnSize);

        List<Cars> carsList = new ArrayList<>();
        for (int turn = 0; turn < turnSize; turn++) {
            cars = cars.moveAll(fuel);
            carsList.add(cars);
        }

        return new GameResponse(carsList);
    }

    private void validateCars(Cars cars) {
        if (Objects.isNull(cars) || cars.isEmpty())
            throw new IllegalArgumentException("경기를 진행할 차가 없습니다.");
    }

    private void validateTurnSize(int turnSize) {
        if (turnSize < 1)
            throw new IllegalArgumentException("경기를 진행할 횟수가 1보다 작습니다.");
    }

    private static class InnerClazz {
        private static final RacingController instance = new RacingController();
    }
}
