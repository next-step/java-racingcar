package racingcar.service;

import racingcar.domain.GameInputData;
import racingcar.domain.GameResultData;
import racingcar.domain.RacingCar;
import racingcar.domain.Record;
import racingcar.domain.collection.CarCollection;
import racingcar.domain.collection.RecordCollection;
import racingcar.service.util.RacingUtil;
import racingcar.view.RacingCarResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    private List<RacingCar> cars;

    private RacingGameService(List<String> carName) {

        cars = CarCollection.racingGameReady(carName);
    }

    public static RacingGameService ready(List<String> carName) {

        return new RacingGameService(carName);
    }

    public GameResultData execute(GameInputData racingCarInput) {

        int tryCount = racingCarInput.getTryCount();
        List<Record> recordList = new ArrayList();

        for(int ROUND = 0; ROUND < tryCount; ROUND++) {
            RacingUtil.playTheGame(cars);

            recordList.add(recordRace(ROUND));

            RacingCarResultView.print(cars);

            System.out.println();
        }

        return GameResultData.of(recordList);
    }

    private Record recordRace(int ROUND) {

        return RecordCollection.create(ROUND, cars);
    }
}
