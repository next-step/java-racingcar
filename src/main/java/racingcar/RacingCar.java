package racingcar;

import racingcar.rule.RacingRule;

public class RacingCar {

    private static final int MOVABLE_MIN_VALUE = 4;
    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    private int distance;

    public int getDistance() {
        return distance;
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int distance) {
        this.name = validateName(name);
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    /**
     * 주어진 수만큼 위치 이동
     * @param number 
     */
    public void move(int number) {
        if(this.canMove(number)) {
            ++this.distance;
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

    /**
     * 이름의 길이 값을 검증
     * @param name 
     * @return
     */
    private String validateName(String name) {
        if(name != null && name.length() <= RacingCar.NAME_MAX_LENGTH) {
            return name;
        }
        throw new IllegalArgumentException("이름의 길이가 적절하지 않습니다.");
    }
}
