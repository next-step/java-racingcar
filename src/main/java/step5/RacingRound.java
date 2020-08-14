package step5;


import step5.dto.Car;
import step5.util.RandomDice;

import java.util.List;

public class RacingRound {

    public void playRound(List<Car> entryList) {
        for(Car car : entryList){
            car.moveRound(RandomDice.rollTheDice());
        }
    }

}
