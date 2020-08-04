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
    private static final int VALID_NAME_MAX_LENGTH = 5;

    private String name = "";

    private int position = 0;

    /**
     * 생성자를 통해 초기화한다.
     */
    public Car() {}

    /**
     * 생성자를 통해 초기화한다.
     *
     * @param name
     */
    public Car(String name) {
        if (name.length() > VALID_NAME_MAX_LENGTH) throw new RuntimeException("자동차의 이름은 5글자를 초과할 수 없습니다.");

        this.name = name;
    }

    /**
     * 0 ~ 9 의 값중에 임의의 값(출력)을 반환한다.
     *
     * @return
     */
    private int getPower() {
        return engine.nextInt(MAX_POWER);
    }

    /**
     * 자동차의 이름을 반환한다.
     *
     * @return
     */
    public String getName() {
        return this.name;
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
