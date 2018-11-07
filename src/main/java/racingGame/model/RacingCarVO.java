package racingGame.model;

public class RacingCarVO {
    private String name;
    private int position;

    public RacingCarVO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
