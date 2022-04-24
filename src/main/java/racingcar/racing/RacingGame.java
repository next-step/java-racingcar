package racingcar.racing;


import racingcar.racing.policy.RacingMovePolicy;
import racingcar.racing.dto.RacingGameParam;
import racingcar.racing.model.Car;
import racingcar.racing.model.RacingRecord;
import racingcar.racing.repository.RacingGameRepository;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int RACING_POLICY_VALUE = 10;

    private static final RacingGameRepository racingGameRepository = new RacingGameRepository();

    private final RacingMovePolicy racingMovePolicy;


    public RacingGame(RacingMovePolicy racingMovePolicy) {
        this.racingMovePolicy = racingMovePolicy;
    }

    public void playGame(RacingGameParam racingGameParam) {
        for (int i = 0; i < racingGameParam.getCarNumber(); i++) {
            racing(new Car(i, racingGameParam.getNames()[i]), racingGameParam.getTryNumber());
        }
    }

    private void racing(Car car, int tryNumber) {
        for(int i = 0; i < tryNumber; i++) {
            car.forward(racingMovePolicy.execute(RACING_POLICY_VALUE));
            saveRacingRecord(new RacingRecord(car.getId(), car.getPosition(), i, car.getParticipantName()));
        }

    }

    private void saveRacingRecord(RacingRecord record) {
        racingGameRepository.save(record);
    }

    public List<RacingRecord> getRacingRecords(int tryNumber) {
        return racingGameRepository.findAllRacingRecordByTryNumber(tryNumber);
    }

    public List<String> getWinners(int tryNumber) {
        List<RacingRecord> recordList = racingGameRepository.findAllRacingRecordByTryNumber(tryNumber - 1);

        int maxPosition = 0;
        for (RacingRecord racingRecord : recordList) {
            maxPosition = Math.max(racingRecord.getCurPos(), maxPosition);
        }

        List<String> winnerList = new ArrayList<>();
        for (RacingRecord racingRecord : recordList) {
            if(racingRecord.getCurPos() == maxPosition) {
                winnerList.add(racingRecord.getParticipantName());
            }
        }

        return winnerList;
    }


}
