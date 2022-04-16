package racingcar.racing;


import racingcar.play.RacingGamePolicy;
import racingcar.racing.dto.RacingGameParam;
import racingcar.racing.service.RacingGameService;

import java.util.List;

public class RacingGame {

    private static final int X_COORDINATE_INIT_VALUE = 0;

    private final RacingGameService racingGameService;

    public RacingGame(RacingGamePolicy racingGamePolicy) {
        this.racingGameService = new RacingGameService(racingGamePolicy);
    }

    public void startRacingGame(RacingGameParam racingGameParam) {
        playGame(racingGameParam.getCarNumber(), racingGameParam.getTryNumber());
    }

    public List<RacingRecord> getResult(int tryNumber) {
        return racingGameService.findAllByTryNumber(tryNumber);
    }

    private void playGame(int carNumber, int tryNumber) {
        for (int i = 0; i < carNumber; i++) {
            racingGameService.playGame(new RacingCar(i, X_COORDINATE_INIT_VALUE), tryNumber);
        }
    }




}
