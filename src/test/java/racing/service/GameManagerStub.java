package racing.service;

import racing.domain.RaceRule;

public class GameManagerStub extends GameManager {

    public GameManagerStub(String carNames, int maxLaps) {
        super(carNames, maxLaps);
    }

    @Override
    public RaceRule raceRule() {
        return () -> true;
    }

}
