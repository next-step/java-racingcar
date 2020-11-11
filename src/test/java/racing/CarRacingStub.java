package racing;

import racing.domain.RaceRule;

public class CarRacingStub extends CarRacing{

    public CarRacingStub(String carNames, int maxLaps) {
        super(carNames, maxLaps);
    }

    @Override
    public RaceRule raceRule() {
        return () -> true;
    }

}
