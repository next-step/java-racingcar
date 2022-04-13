package racingcar;

import java.util.HashMap;
import java.util.Random;


public class RacingCar {

    private static final int FORWARD_CONDITION = 4;
    private HashMap<Integer, Integer> racingStatus;
    private static final Random random = new Random();

    public HashMap<Integer, Integer> start(int participantNumber, int tryNumber) {
        initialize(participantNumber);

        for (int i = 0; i < tryNumber; i++) {
            racing(participantNumber);
        }

        return racingStatus;
    }

    private void initialize(int participantNum) {
        racingStatus = new HashMap<>();

        putRacingStatusValue(participantNum);
    }

    private void putRacingStatusValue(int participantNum) {
        for (int i = 0; i < participantNum; i++) {
            racingStatus.put(i, 0);
        }
    }

    private void racing(int participantNumber) {
        for (int idx = 0; idx < participantNumber; idx++) {
            recordForwardValue(idx, random.nextInt(10));
        }
    }

    private void recordForwardValue(int idx, int randomValue) {
        if (randomValue > FORWARD_CONDITION) {
            save(idx, racingStatus.get(idx));
        }
    }

    private void save(int idx, int value) {
        racingStatus.put(idx, value + 1);
    }


}
