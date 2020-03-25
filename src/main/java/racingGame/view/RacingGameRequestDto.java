package racingGame.view;

public class RacingGameRequestDto {

    private String participates;
    private int round;

    public RacingGameRequestDto(String participates, int round) {
        this.participates = participates;
        this.round = round;
    }

    public String getParticipates() {
        return participates;
    }

    public int getRound() {
        return round;
    }
}
