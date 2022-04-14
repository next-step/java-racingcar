package racingcar.racing;


import racingcar.play.RacingGamePolicy;

import java.util.List;

public class RacingGameService {

    private static final RacingGameRepository racingGameRepository = new RacingGameRepository();

    private static final int RACING_POLICY_VALUE = 10;

    private final RacingGamePolicy racingPolicy;

    public RacingGameService(RacingGamePolicy racingPolicy) {
        this.racingPolicy = racingPolicy;
    }

    public void playGame(RacingCar racingCar, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            racingCar.setProgress(racingPolicy.racing(racingCar.getProgress(), RACING_POLICY_VALUE));
            racingGameRepository.save(racingCar);
        }

    }

    public List<RacingCar> findAll() {
        return racingGameRepository.findAll();
    }

}
