package racingcar;

import org.apache.commons.lang3.StringUtils;

public class RacingCar {

    public final static int RANDOM_BOUND = 10;
    public final static int LIMIT_MIN = 4;
    public final static int LIMIT_MAX = 9;

    private int position; // 최종 위치

    /**
     * 확인할 숫자에 따라 전진 할 수 있는지 아닌지를 반환한다.<br />
     *
     * @param num 전진 가능 여부 판단이 필요한 숫자
     * @return boolean
     */
    public static boolean checkCanMove(int num) {
        return num >= LIMIT_MIN && num <= LIMIT_MAX;
    }

    public int makeRandomMove() {
        int randomNum = RacingUtil.generateRandomNum(RANDOM_BOUND);
        int move = checkCanMove(randomNum) ? 1 : 0;

        this.position = this.position + move;

        return this.position;
    }

    public void printPosition() {
        System.out.println(StringUtils.repeat("-", this.position));
    }
}
