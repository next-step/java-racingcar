package racingcar.domain;

public class RacingResult {
    private final Participants participants;

    public RacingResult(Participants participants) {
        this.participants = participants;
    }

    public void moveCarIfPositionChanged(int index, boolean bool) {
        if (bool) {
            participants.get(index).go();
        }
    }
}
