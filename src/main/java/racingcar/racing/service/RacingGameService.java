package racingcar.racing.service;


import racingcar.play.RacingGamePolicy;
import racingcar.racing.RacingCar;
import racingcar.racing.RacingRecord;
import racingcar.racing.repository.RacingGameRepository;

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
            racingCar.forward(racingPolicy.racing(RACING_POLICY_VALUE));
            racingGameRepository.save(racingCar, i);
        }
    }

    public List<RacingRecord> findAllByTryNumber(int tryNumber) {
        return racingGameRepository.findAllByTryNumber(tryNumber);
    }

}
