package racingcar.domain;

public record CarSnapshot(String name, int distance) {
    public CarSnapshot {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("이동 거리는 음수일 수 없습니다.");
        }
    }
}
