package racingcar.backend.service;

import racingcar.backend.domain.*;

public class PlayService {

    public GameRecords play(Cars cars, int times) {
        GameRecords gameRecords = new GameRecords();
        for (int round = 0; round < times; round++) {
            gameRecords.add(cars.play());
        }
        return gameRecords;
    }
}
