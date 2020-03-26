package racingGame.domain.car;

class Position {
    private int position;

    Position(int position) {
        verifyPosition(position);
        this.position = position;
    }

    private void verifyPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이하의 숫자가 지정될 수 없습니다.");
        }
    }

    void forward() {
        position++;
    }

    int getPosition() {
        return position;
    }
}
