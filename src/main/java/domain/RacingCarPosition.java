package domain;

public class RacingCarPosition {

    private String name;
    private Integer position;

    public RacingCarPosition(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
