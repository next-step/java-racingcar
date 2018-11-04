package racinggame;

public class RacingGame {
    private int raceTime;
    private int[] carPosition;

    private static final int CAN_MOVE_NUMBER = 4;

    public RacingGame(int carCount, int raceTime) {
        this.raceTime = raceTime;
        this.carPosition = new int[carCount];
    }

    public int[] getCarPosition() {
        return carPosition;
    }

    /**
     * 레이싱 경기 1회 시도
     */
    public int[] raceOneTime() {
        for (int i = 0; i < this.carPosition.length; i++) {
            moveCar(i);
        }
        reduceRaceTime();

        return this.carPosition;
    }

    /**
     * 자동차를 랜덤 결과에 따라 움직이게 한다.
     * @param carPositionIndex
     */
    public void moveCar(int carPositionIndex) {
        if(isCarMove(RandomUtils.getRandom10())) {
            this.carPosition[carPositionIndex]++;
        }
    }

    /**
     * 자동차가 움직일 수 있는지 확인
     * @param number
     * @return
     */
    public boolean isCarMove(int number) {
        if(number > CAN_MOVE_NUMBER) {
            return true;
        }
        return false;
    }

    /**
     * 레이싱 경기 시도시 경기횟수 1회 차감
     * @return
     */
    public int reduceRaceTime() {
        return raceTime--;
    }

    /**
     * 레이스 종료 여부 확인
     * @return
     */
    public boolean isRaceEnd() {
        return raceTime < 1;
    }
}
