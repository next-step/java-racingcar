package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private final Cars cars;
    private final Round round;

    public CarRacing(Cars cars) {
        this(cars, Round.NULL);
    }

    public CarRacing(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public CarRacingResult start() {
        List<CarRoundResult> carRoundResultList = new ArrayList<>();

        while (round.isRoundContinue()) {
            cars.moveCars();
            carRoundResultList.add(new CarRoundResult(cars));
            round.reduceRound();
        }
        return new CarRacingResult(carRoundResultList, new Winner(cars));
    }
}
