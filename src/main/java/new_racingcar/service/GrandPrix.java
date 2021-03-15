package new_racingcar.service;

import new_racingcar.strategy.MoveOneStrategy;
import new_racingcar.constant.MsgConstants;
import new_racingcar.domain.Cars;
import new_racingcar.domain.Round;
import new_racingcar.strategy.MoveZeroStrategy;

import java.util.ArrayList;
import java.util.List;

public class GrandPrix {
    private Cars cars;
    private List<Round> rounds = new ArrayList<>();

    private int roundCount;

    public GrandPrix(List<String> names, int roundCount) {
        isRoundCountVaild(roundCount);
        this.cars = new Cars(names, new MoveOneStrategy());
        this.roundCount = roundCount;
    }

    private void isRoundCountVaild(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException(MsgConstants.ROUND_ERROR_MESSAGE);
        }
    }

    public List<Round> start() {
        for(int i = 0; i < roundCount; i++) {
            Cars newCars = cars.run();
            rounds.add(new Round(newCars));
        }

        return rounds;
    }
}
