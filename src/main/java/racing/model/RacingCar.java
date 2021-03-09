package racing.model;

public class RacingCar {

    private final RacingCarName racingCarName;
    private final Position position;

    public RacingCar(String racingCarName, int position) {
        this.racingCarName = new RacingCarName(racingCarName);
        this.position = new Position(position);
    }

    /**
     * 자동차 이름을 알려주는 메서드
     */
    public String getRacingCarName() {
        return racingCarName.getRacingCarName();
    }

    /**
     * 자동차 위치를 알려주는 메서드
     */
    public int getPosition() {
        return position.getPosition();
    }

    /**
     * 자동차 위치를 이동시켜주는 메서드
     */
    public void move(int ramdomValue) {
        if (isForward(ramdomValue)) {
            position.move();
        }
    }

    /**
     * 이동 거리가 4이상인지 판단하는 메서드
     */
    public boolean isForward(int ramdomValue) {
        return ramdomValue > 3;
    }

    /**
     * 포지션이 같은지 판단하는 메서드
     */
    public Boolean isSame(int position) {
        return this.position.equals(position);
    }
}
