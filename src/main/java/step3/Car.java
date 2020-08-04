package step3;

import java.util.Random;

/***
 * 자동차 게임에서 이용되는 자동차 클래스
 * 전진 or 정지 기능이 있다.
 */
public class Car {

    private Random engine = new Random();

    private static final int MAX_POWER = 10;
    private static final int MIN_POWER = 4;

    private int position = 0;

    /**
     * 0 ~ 9 의 값중에 임의의 값(출력)을 반환한다.
     *
     * @return
     */
    private int getPower() {
        return engine.nextInt(MAX_POWER);
    }

    /**
     * 순간 출력을 내어 전진한다.
     * 출력이 4보다 작은 경우 움직이지 않는다.
     */
    public void go() {
        this.go(getPower());
    }

    /**
     * 전진한다.
     * 출력이 4보다 작은 경우 움직이지 않는다.
     *
     * @param power
     */
    public void go(int power) {
        if (power < MIN_POWER)
            return;

        position++;
    }

    /**
     * 현재 위치를 반환한다.
     *
     * @return
     */
    public int getCurrentPosition() {
        return position;
    }
}
