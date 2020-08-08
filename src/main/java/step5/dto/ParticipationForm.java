package step5.dto;

public class ParticipationForm {

    private final String[] participationNames;

    private final int attemptCount;

    public ParticipationForm(String[] participationNames, int attemptCount) {
        this.participationNames = participationNames;
        this.attemptCount = attemptCount;
    }

    public String[] getParticipationNames() {
        return participationNames;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
