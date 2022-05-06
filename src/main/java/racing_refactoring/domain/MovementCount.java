package racing_refactoring.domain;

class MovementCount {
    private final int movementCount;

    MovementCount(int movementCount) {
        if (movementCount < 1) {
            throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
        }
        this.movementCount = movementCount;
    }
}
