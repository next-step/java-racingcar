package racinggame.dto;

import java.util.Arrays;
import java.util.List;

public class RacingGameInfo {
    private static final String RACING_CAR_DELIMITER = ",";

    private final List<String> participantCars;
    private final int numberOfAttempt;

    public RacingGameInfo(String inputParticipants, String numberOfAttempt) {
        try {
            int inputNumberOfAttempt = Integer.parseInt(numberOfAttempt);

            validate(inputNumberOfAttempt);

            this.participantCars = Arrays.asList(inputParticipants.split(RACING_CAR_DELIMITER));
            this.numberOfAttempt = inputNumberOfAttempt;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도횟수는 숫자로 입력해야합니다. : " + numberOfAttempt);
        }
    }

    private void validate(int inputNumberOfAttempt) {
        if (inputNumberOfAttempt <= 0) {
            throw new IllegalArgumentException("시도횟수는 0보다 커야합니다");
        }
    }

    public List<String> getParticipantCars() {
        return participantCars;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }
}
