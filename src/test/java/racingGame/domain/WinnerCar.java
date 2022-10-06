package racingGame.domain;

import racingGame.domain.Car;
import racingGame.racingRule.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class WinnerCar implements Car {

    private final List<Boolean> carTrace = new ArrayList<>();
    private final String carName;
    private final RacingRule racingRule;

    public WinnerCar(String carName, RacingRule racingRule) {
        this.carName = carName;
        this.racingRule = racingRule;
    }

    @Override
    public void move() {
        if (racingRule.moveOrNot()){
            carTrace.add(true);
            return;
        }
        carTrace.add(false);
    }

    @Override
    public long getTraceSize() {
        return carTrace.stream().filter(i->i).count();
    }

    @Override
    public String convertRound(String separator, String mark) {
        return null;
    }

    @Override
    public String getCarName() {
        return this.carName;
    }
}
