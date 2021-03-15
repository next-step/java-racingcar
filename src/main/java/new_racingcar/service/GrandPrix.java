package new_racingcar.service;

import new_racingcar.domain.Round;
import new_racingcar.strategy.MoveOneStrategy;
import new_racingcar.constant.MsgConstants;
import new_racingcar.domain.Cars;
import new_racingcar.domain.RoundRecord;

import java.util.ArrayList;
import java.util.List;

public class GrandPrix {
    private Cars cars;
    private List<RoundRecord> roundRecords = new ArrayList<>();

    private Round round;

    public GrandPrix(List<String> names, int roundCount) {
        this.cars = new Cars(names, new MoveOneStrategy());
        this.round = new Round(roundCount);
    }

    public List<RoundRecord> start() {
        while (round.isGameEnd()) {
            Cars newCars = cars.run();
            roundRecords.add(new RoundRecord(newCars));
        }

        return roundRecords;
    }


}
