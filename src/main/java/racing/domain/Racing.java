package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.dto.RacingInfo;

public class Racing {

    private final List<Car> cars;
    private final Round round;

    public Racing(RacingInfo info) {
        this.round = new Round(info.getTotalRoundNumber());
        this.cars = CarGenerator.createCars(info.getCarNames(), new RandomMoveRule());
    }

    public void race() {
        round.play(cars);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public RacingResult getResult() {
        return round.getRacingResult();
    }
}
