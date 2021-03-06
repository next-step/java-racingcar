package racing.model;

public class RacingCar {

    // 이름이 중복될 수 있는 관게로 ID를 부여한다.
    private long racingCarId;
    private String racingCarName;
    private int position;

    public RacingCar(long racingCarId, String racingCarName, int position) {
        this.racingCarId = racingCarId;
        this.racingCarName = racingCarName;
        this.position = position;
    }

    /**
     * 자동차 Id을 알려주는 메서드
     */
    public long getRacingCarId() {
        return racingCarId;
    }

    /**
     * 자동차 이름을 알려주는 메서드
     */
    public String getRacingCarName() {
        return racingCarName;
    }

    /**
     * 자동차 위치를 알려주는 메서드
     */
    public int getPosition() {
        return position;
    }

    /**
     * 자동차 위치를 이동시켜주는 메서드
     */
    public int move(int moveCount) {
        if (isForward(moveCount)) {
            this.position += moveCount;
        }
        return position;
    }

    /**
     * 이동 거리가 4이상인지 판단하는 메서드
     */
    public boolean isForward(int moveCount) {
        return moveCount > 3;
    }
}
