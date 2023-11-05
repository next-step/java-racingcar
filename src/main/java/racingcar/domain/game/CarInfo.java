package racingcar.domain.game;

public class CarInfo {

    private final int carCount;

    public CarInfo(int carCount) {
        validateCarCount(carCount);

        this.carCount = carCount;
    }

    private void validateCarCount(int carCount) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("최소 1개 이상의 자동차를 만들어야합니다.");
        }
    }

    public int getCarCount() {
        return carCount;
    }
}
