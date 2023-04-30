package racing.domain;

import java.util.List;

public class Winner {

    public static List<Car> award(RacingCars racingCars) {
        return racingCars.winnerCars();
    }

}
