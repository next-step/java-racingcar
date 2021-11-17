package racingcar.service;

import racingcar.domain.GameInputData;
import racingcar.domain.GameResultData;
import racingcar.domain.RacingCars;
import racingcar.domain.Record;
import racingcar.domain.collection.RecordCollection;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    private RacingCars cars;

    private RacingGameService(List<String> carName) {

        cars = RacingCars.racingGameReady(carName);
    }

    public static RacingGameService ready(List<String> carName) {

        return new RacingGameService(carName);
    }

    public GameResultData execute(GameInputData racingCarInput) {

        int tryCount = racingCarInput.getTryCount();
        List<Record> recordList = new ArrayList();

        for(int ROUND = 0; ROUND < tryCount; ROUND++) {
            RacingCars.playTheGame(cars);
            recordList.add(recordRace(ROUND));
        }

        return GameResultData.of(recordList);
    }

    private Record recordRace(int ROUND) {

        return RecordCollection.create(ROUND, cars);
    }
}
