package racingcar.racing;


import racingcar.DataKey;
import racingcar.RacingInputData;
import racingcar.play.RacingGamePolicy;
import racingcar.play.ZeroToNineRandomPolicy;

import java.util.List;

public class RacingGame {

    private static final int PROGRESS_INIT_VALUE = 0;

    private final RacingGameService racingGameService;

    private static final String carNumberKey = DataKey.CARNUMBER.getKeyName();
    private static final String tryNumberKey = DataKey.TRYNUMBER.getKeyName();

    public RacingGame(RacingGamePolicy racingGamePolicy) {
        this.racingGameService = new RacingGameService(racingGamePolicy);
    }

    public void startRacingGame(RacingInputData racingInputData) {
        playGame(racingInputData.getCarNumber(carNumberKey),
                racingInputData.getTryNumber(tryNumberKey));
    }

    public List<RacingCar> getResult() {
        return racingGameService.findAll();
    }

    private void playGame(int carNumber, int tryNumber) {
        for (int i = 0; i < carNumber; i++) {
            racingGameService.playGame(new RacingCar(i, PROGRESS_INIT_VALUE), tryNumber);
        }
    }




}
