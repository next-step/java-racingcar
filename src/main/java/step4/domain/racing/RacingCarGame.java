package step4.domain.racing;

import step4.domain.ipnut.InputNames;
import step4.domain.ipnut.InputRound;
import step4.dto.ResponseDto;

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

    public final void nextRound() {
        round.nextRound();
    }

    public final ResponseDto responseDto() {
        return new ResponseDto(cars);
    }

    private final int maxPosition(){
        // cars.cars().stream().
    }

    public final Winners winners() {
        return cars.winners()
    }

}
