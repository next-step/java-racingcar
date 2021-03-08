package step3.ui.dto;

/**
 * 레이스 요청 파라미터 관리 클래스
 */
public class RequestRacingGame {

    private final int carCount;
    private final int tryCount;

    public RequestRacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCarCount() {
        return carCount;
    }
}
