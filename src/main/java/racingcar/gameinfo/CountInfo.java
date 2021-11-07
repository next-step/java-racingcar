package racingcar.gameinfo;

public class CountInfo {

    private final int carCount;
    private final int tryCount;

    public CountInfo(int carCount, int tryCount) {
        if(carCount < 0 || tryCount < 0) throw new IllegalArgumentException("입력 값은 0보다 커야합니다.");
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
