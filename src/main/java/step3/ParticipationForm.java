package step3;

public class ParticipationForm {

    private Integer participationCount;

    private Integer attemptCount;

    public ParticipationForm(Integer participationCount, Integer attemptCount) {
        this.participationCount = participationCount;
        this.attemptCount = attemptCount;
    }

    public Integer getParticipationCount() {
        return participationCount;
    }

    public Integer getAttemptCount() {
        return attemptCount;
    }
}
