package racingcar;

public class RacingCar {

    private int distance;

    public int getDistance() {
        return distance;
    }

    /**
     * 자동차의 거리를 1증가시킵니다.
     * @return added distance
     */
    public int addDistance() {
        return ++this.distance;
    }
}
