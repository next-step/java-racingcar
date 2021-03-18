package step4.domain.racing;

import step4.domain.ipnut.InputNames;
import step4.domain.ipnut.InputRound;

public class RacingCarGame {

    private final Cars cars;
    private final Round round;

    public RacingCarGame(InputNames inputNames, InputRound inputRound) {
        this(new Cars(inputNames), new Round(inputRound));
    }

    public RacingCarGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public final boolean hasNext() {
        return round.hasNext();
    }

}
