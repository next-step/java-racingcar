package racingGame.model;

public class RacingCarDTO {
    private String name;
    private int position;

    public RacingCarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMatchPosition(int position) {
        return this.position == position;
    }
}
