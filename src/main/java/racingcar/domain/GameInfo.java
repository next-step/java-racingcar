package racingcar.domain;

public class GameInfo {
    private final int carCount;
    private final int gameCount;

    public GameInfo(int carCount, int gameCount) {
        validate(carCount, gameCount);

        this.carCount = carCount;
        this.gameCount = gameCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    private void validate(int carCount, int gameCount) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("최소 1개 이상의 자동차를 만들어야합니다.");
        }

        if (gameCount <= 0) {
            throw new IllegalArgumentException("최소 1번 이상의 게임을 진행해야 합니다.");
        }
    }
}
