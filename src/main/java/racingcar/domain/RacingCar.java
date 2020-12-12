package racingcar.domain;

public class RacingCar {

    private static final int MOVABLE_MIN_VALUE = 4;
    private static final int MOVE_DISTANCE = 1;

    private final Name name;

    private final Distance distance;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    /**
     * 주어진 수만큼 위치 이동
     * @param number 
     */
    public void move(int number) {
        if(this.canMove(number)) {
            this.distance.addDistance(RacingCar.MOVE_DISTANCE);
        }
    }

    /**
     * 주어진 값이 전진해야하는 조건이 맞는지 체크합니다.
     * @param number
     * @return canMove
     */
    private boolean canMove(int number) {
        return number >= RacingCar.MOVABLE_MIN_VALUE;
    }

}
