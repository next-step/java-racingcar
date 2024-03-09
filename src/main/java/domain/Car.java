package domain;

public class Car {

    private int moveCount;
    private final Position position;

    public Car(int moveCount) {
        this.moveCount = moveCount;
        this.position = new Position();
    }

    public Position move(int random) {
        reduceMoveCount();
        if (random < 4) {
            return position;
        }

        position.forward();
        return position;
    }

    private void reduceMoveCount() {
        if (moveCount < 1) {
            throw new IllegalStateException("이동 횟수가 모두 소진되었습니다.");
        }
        moveCount--;
    }
}
