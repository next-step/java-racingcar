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
        RacingCar car = racingPolicy.racing(racingCar, tryNumber, RACING_POLICY_VALUE);
        racingGameRepository.save(car);
    }

    public List<RacingCar> findAll() {
        return racingGameRepository.findAll();
    }

}
