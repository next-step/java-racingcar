package racingcar;

public class RacingCar {

    private static final int MOVABLE_MIN_VALUE = 4;

    private String name;

    private int distance;

    public int getDistance() {
        return distance;
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    /**
     * 자동차의 거리를 1증가시킵니다.
     * @return added distance
     */
    public int addDistance() {
        return ++this.distance;
    }

    public void move(int number) {
        if(this.canMove(number)) {
            this.addDistance();
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
