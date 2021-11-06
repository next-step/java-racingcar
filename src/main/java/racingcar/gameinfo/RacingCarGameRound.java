package racingcar.gameinfo;

import racingcar.car.Car;
import racingcar.moverule.MoveRule;

import java.util.List;

public class RacingCarGameRound {

    private final MoveRule moveRule;

    public RacingCarGameRound(MoveRule moveRule){
        this.moveRule = moveRule;
    }

    public void play(List<Car> carList) {
        for(Car car : carList) {
           moveRule.move(car);
        }
    }
}