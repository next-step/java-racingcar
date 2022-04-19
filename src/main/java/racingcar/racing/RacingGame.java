package racingcar.racing;


import racingcar.play.RacingMovePolicy;
import racingcar.racing.model.Car;
import racingcar.racing.model.RacingRecord;
import racingcar.racing.repository.RacingGameRepository;

import java.util.List;

public class RacingGame {

    private static final int X_COORDINATE_INIT_VALUE = 0;

    private static final int RACING_POLICY_VALUE = 10;

    private static final RacingGameRepository racingGameRepository = new RacingGameRepository();

    private final RacingMovePolicy racingPolicy;


    public RacingGame(RacingMovePolicy racingGamePolicy) {
        this.racingPolicy = racingGamePolicy;
    }

    public void startRacingGame(int carNumber, int tryNumber) {
        for (int i = 0; i < carNumber; i++) {
            playGame(new Car(i, X_COORDINATE_INIT_VALUE), tryNumber);
        }
    }

    private void playGame(Car car, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            car.forward(racingPolicy.racing(RACING_POLICY_VALUE));

            RacingRecord record = new RacingRecord(car.getId(), car.getxCoordinate(), tryNumber);
            racingGameRepository.save(record);
        }
    }

    public List<RacingRecord> getResult(int tryNumber) {
        return racingGameRepository.findAllByTryNumber(tryNumber);
    }






}
