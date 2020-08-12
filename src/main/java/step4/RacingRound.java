package step4;

import step4.dto.Car;
import step4.util.RandomDice;

import java.util.List;

public class RacingRound {

    public void playRound(List<Car> entryList) {
        for(Car car : entryList){
            car.moveRound(RandomDice.rollTheDice());
        }
    }

}
