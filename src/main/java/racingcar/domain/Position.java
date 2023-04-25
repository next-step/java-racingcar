package racingcar.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.validateNegative(position);
        this.position = position;
    }

    public void moveForth() {
        position++;
    }

    public int showPosition() {
        return position;
    }

    public int chooseRemoteDistance(int distance) {
        return position > distance ? position : distance;
    }

    public boolean isSameDistance(int distance) {
        return position == distance;
    }

    private void validateNegative(int position) {
        if (isNegative(position)) {
            throw new IllegalArgumentException("위치는 음수값을 가질 수 없습니다.");
        }
    }

    private boolean isNegative(int position) {
        return position < 0 ? true : false;
    }

}
