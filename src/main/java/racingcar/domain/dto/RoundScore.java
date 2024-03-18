package racingcar.domain.dto;

public class RoundScore {
    private final int position;

    public RoundScore(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
