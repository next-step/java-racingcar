package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Movement;
import racingcar.domain.TrialCoin;
import racingcar.domain.dto.CarDto;

public class RacingService {

    private final Movement movement;
    private final Cars cars;
    private final TrialCoin trialCoin;

    public RacingService(Movement movement, int howMany, int trials) {
        this.movement = movement;
        this.cars = Cars.ofQuantity(howMany);
        this.trialCoin = new TrialCoin(trials);
    }

    public List<CarDto> race() {
        cars.move(movement);
        trialCoin.decrease();
        return cars.getCarsInfo();
    }

    public boolean isRaceOnGoing() {
        return trialCoin.isCoinLeft();
    }
}
