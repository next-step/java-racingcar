package camp.nextstep.racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingGame {

    private final CarGroup carGroup;
    private Round round;

    public RacingGame(String carNames, Round round) {
        this(CarFactory.of(carNames), round);
    }

    public RacingGame(List<Car> cars, Round round) {
        this.carGroup = new CarGroup(cars);
        this.round = round;
    }

    public void race(MoveCondition moveCondition) {
        carGroup.move(moveCondition);
        round.finishPerRound();
    }

    public boolean isRacing() {
        return !round.isFinished();
    }

    public List<Car> getWinners() {
        return carGroup.getWinners();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(carGroup.getCars());
    }

}
