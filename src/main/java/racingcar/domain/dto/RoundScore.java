package racingcar.domain.dto;

public class RoundScore {
    private final String participantName;
    private final int position;

    public RoundScore(String participantName, int position) {
        this.participantName = participantName;
        this.position = position;
    }

    public String getParticipantName() {
        return participantName;
    }

    public int getPosition() {
        return position;
    }
}
