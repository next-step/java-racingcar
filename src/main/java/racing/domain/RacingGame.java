package racing.domain;

import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<RacingCar> gameCars;

    public RacingGame(int count) {
        this.gameCars = createCarList(count);
    }

    public List<RacingCar> getGameCars() {
        return gameCars;
    }

    private List<RacingCar> createCarList(int count) {
        List<RacingCar> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            carList.add(new RacingCar());
        }
        return carList;
    }

    public void setMoveStrategyOfCars(MoveStrategy moveStrategy) {
        for (RacingCar gameCar : gameCars) {
            gameCar.setMoveStrategy(moveStrategy);
        }
    }

    public void progressCycle() {
        for (RacingCar gameCar : gameCars) {
            gameCar.move();
        }
    }

    public List<Integer> result() {
        List<Integer> carStatusList = new ArrayList<>();
        for (RacingCar gameCar : gameCars) {
            carStatusList.add(gameCar.getPosition());
        }
        return carStatusList;
    }
}
