package racing;

public class RacingCarPosition {

    private Integer position;

    public RacingCarPosition() {
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public Integer getPosition() {
        return this.position;
    }

}
