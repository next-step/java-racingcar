package step3.dto;

public class ParticipationForm {

    private final int participationCount;

    private final int attemptCount;

    public ParticipationForm(int participationCount, int attemptCount) {
        this.participationCount = participationCount;
        this.attemptCount = attemptCount;
    }

    public int getParticipationCount() {
        return participationCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
