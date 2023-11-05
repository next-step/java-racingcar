package game;

/**
 * 초간단 자동차 경주 게임의 자동차 개체 하나를 나타냅니다.
 */
public class Car {
    /** 자동차의 현재 위치를 나타냅니다. */
    private int position = 0;

    /**
     * 초기 위치를 지정하여 자동차를 생성합니다.
     * @param initPosition 초기 위치. 0 이상이여야 합니다.
     */
    public Car(int initPosition) {
        if (initPosition < 0) {
            throw new IllegalArgumentException("위치는 0 이상이어야 하지만 " + initPosition + "이 주어졌습니다.");
        }

        this.position = initPosition;
    }

    /**
     * 초기 위치가 1인 자동차를 생성합니다.
     */
    public Car() {
        this(1);
    }


    /**
     * 자동차의 현재 위치를 궤적 문자열로 만들어 생성합니다.
     *
     * @return "---"와 같은 자동차 궤적 문자열.
     */
    public String getMoveTrajectory() {
        StringBuilder trajectory = new StringBuilder();

        for (int i = 1; i <= this.position; i++) {
            trajectory.append('-');
        }

        return trajectory.toString();
    }
}
