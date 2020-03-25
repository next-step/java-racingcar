package racingGame.domain.participant;

import java.util.List;

public class RoundScore {

    private List<ParticipantScore> participantScores;

    public RoundScore(List<ParticipantScore> participantScores) {
        this.participantScores = participantScores;
    }

    public List<ParticipantScore> getRecords() {
        return participantScores;
    }
}