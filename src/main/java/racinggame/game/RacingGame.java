package racinggame.game;

import racinggame.car.Car;
import racinggame.car.CarGroup;
import racinggame.car.VictoryCar;
import racinggame.rule.RacingRule;

import java.util.List;

public class RacingGame {

    private int tryCnt;
    private RacingRule racingRule;
    private CarGroup carGroup;


    public RacingGame(String[] carNames, int tryCnt, RacingRule racingRule){
        carGroup = new CarGroup(carNames);
        this.tryCnt = tryCnt;
        this.racingRule = racingRule;
    }

    public boolean nextRacingGame() {
        return tryCnt > 0;
    }

    public void move() {
        tryCnt--;
        carGroup.carMove(racingRule);
    }

    public List<Car> getCar() {
        return carGroup.getGroupCars();
    }

    public List<String> getVictorCar() {
        return new VictoryCar(getCar()).getVictorCar();
    }
}
