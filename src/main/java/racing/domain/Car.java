package racing.domain;

public class Car {

    private static final String MOVE_PATTERN = "-";
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int moveNumber) {
        position += moveNumber;
    }

    public String positionStatus() {
        StringBuffer sb = new StringBuffer();
        sb.append(MOVE_PATTERN.repeat(position));
        return sb.toString();
    }
}
