package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.Winners;
import racingcar.service.strategy.MoveStrategy;

public class GameLauncher {

    private final List<Car> racingCarList;
    private final int endRaceCount;
    private int currentCount;

    public GameLauncher(List<String> nameList, int endRaceCount) {
        racingCarList = new ArrayList<>();
        for (String name : nameList) {
            racingCarList.add(new RacingCar(name));
        }

        this.currentCount = 0;
        this.endRaceCount = endRaceCount;
    }

    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : racingCarList) {
            car.move(moveStrategy);
        }
        currentCount++;
    }

    public boolean isEnd() {
        return endRaceCount <= currentCount;
    }

    public Winners getWinner() {
        return new Winners(racingCarList);
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }
}

