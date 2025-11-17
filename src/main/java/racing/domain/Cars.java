package racing.domain;

public class Cars {

    private final int carCount;

    public Cars(int carCount) {
        validateCount(carCount);
        this.carCount = carCount;
    }

    private void validateCount(int carCount) {
        if (carCount == 1) {
            throw new RuntimeException("자동차 경주를 진행하기 위해서는 두 대 이상의 자동차가 필요합니다.");
        }
    }
}
