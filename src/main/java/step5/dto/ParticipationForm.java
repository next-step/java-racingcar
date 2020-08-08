package step5.dto;

import java.util.Arrays;

import static step5.constants.MessageConstant.CAR_NAME_LENGTH_SHOULD_UNDER_FIVE;

public class ParticipationForm {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String[] participationNames;

    private final int attemptCount;

    public ParticipationForm(String[] participationNames, int attemptCount) {
        throwIfLengthOverFive(participationNames);
        this.participationNames = participationNames;
        this.attemptCount = attemptCount;
    }

    public String[] getParticipationNames() {
        return participationNames;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    private void throwIfLengthOverFive(String[] split) {
        if(Arrays.stream(split).anyMatch(string -> string.length() > MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_SHOULD_UNDER_FIVE);
        }
    }
}
