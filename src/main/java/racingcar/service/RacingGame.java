package racingcar.service;

import racingcar.domain.*;
import racingcar.repository.RacingCarRepository;
import racingcar.view.RacingGameResult;

import java.util.List;

public class RacingGame {
    private final RacingCarRepository carTable;
    private final MoveStrategy moveStrategy;

    public RacingGame(RacingCarRepository racingCarRepository) {
        this.carTable = racingCarRepository;
        moveStrategy = new RandomMoveStrategy();
    }

    public RacingGame(RacingCarRepository racingCarRepository, MoveStrategy moveStrategy) {
        this.carTable = racingCarRepository;
        this.moveStrategy = moveStrategy;
    }

    public RacingGameResult start(RacingRequest request) {
        join(request.getCarNames());
        return race(request.getTryCount());
    }

    public void join(String carNames) {
        join(Cars.of(carNames));
    }

    public void join(Cars cars) {
        carTable.saveAll(cars);
    }

    private RacingGameResult race(int tryCount) {
        RacingGameResult result = new RacingGameResult();

        Cars cars = carTable.findAll();
        result.record(cars);

        for (int i = 0; i < tryCount; i++) {
            cars.move(moveStrategy);
            result.record(cars);
        }

        result.setWinners(cars.findWinners());

        clearAndSave(cars);
        return result;
    }

    private void clearAndSave(Cars cars) {
        carTable.clear();
        carTable.saveAll(cars);
    }

    public int joinCount() {
        return carTable.findAll()
                        .size();
    }

    public List<Car> getCars() {
        return carTable.findAll()
                        .getElements();
    }
}
