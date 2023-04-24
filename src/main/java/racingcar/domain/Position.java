package racingcar.domain;

public class Position {

    private int position = 0;

    public Position(int position) {
        this.position = position;
    }

    public void moveForth() {
        position++;
    }

    public int showPosition() {
        return position;
    }

    public int chooseLongerDistance(int distance) {
        return position > distance ? position : distance;
    }

    public boolean isSamDistance(int distance) {
        return position == distance;
    }

}
