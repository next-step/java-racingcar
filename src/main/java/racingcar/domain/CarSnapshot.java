package racingcar.domain;

public record CarSnapshot(String name, int distance) {
    public CarSnapshot {
        validateName(name);
        validateDistance(distance);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("이동 거리는 음수일 수 없습니다.");
        }
    }

    public boolean hasSameDistance(int otherDistance) {
        return this.distance == otherDistance;
    }
}
