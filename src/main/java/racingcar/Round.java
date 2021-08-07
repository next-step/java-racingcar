package racingcar;

import java.util.LinkedList;
import java.util.List;

public class Round {

    Cars cars;
    public Round(Cars carsFromPreviousRound) {
        cars = new Cars(carsFromPreviousRound);
    }

    public Cars moveCars() {
        return cars.move();
    }


}
