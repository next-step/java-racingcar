package racinggame;

import racinggame.rule.RacingRule;
import racinggame.rule.RandomNumberRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private int tryCnt;
    private CarList carList;
    private RacingRule racingRule;


    public RacingGame(String[] carNames, int tryCnt, RacingRule racingRule){
        carList = new CarList(carNames);
        this.tryCnt = tryCnt;
        this.racingRule = racingRule;
    }

    public boolean nextRacingGame() {
        return tryCnt > 0;
    }

    public void move() {
        tryCnt--;
        carList.carMove(racingRule);
    }

    public List<Car> getCar() {
        return carList.getCars();
    }

    public List<String> getVictorCar() {
        return carList.getVictorCar();
    }
}
