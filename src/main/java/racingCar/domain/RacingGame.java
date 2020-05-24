package racingCar.domain;

import racingCar.domain.moveStrategy.MoveBehavior;
import racingCar.dto.RacingGameInfo;

import java.util.*;

public class RacingGame {
    private final String[] carNames;
    private final int time;
    private List<RacingCar> racingCarList;

    public RacingGame(RacingGameInfo racingGameInfo) {
        this.carNames = racingGameInfo.getCarNames();
        this.time = racingGameInfo.getTime();
        initRacingCars();
    }

    private void initRacingCars() {
        racingCarList = new ArrayList<>();
        Arrays.stream(carNames).forEach(name -> racingCarList.add(new RacingCar(name)));
    }

    // TODO 구현
    public void move(MoveBehavior moveBehavior) {
        racingCarList.forEach(racingCar -> racingCar.move(moveBehavior.isMove()));
    }

    public int getTime() {
        return time;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
