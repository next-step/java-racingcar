package study.step3.model;

/**
 * Car Class
 *
 * 자동차의 정보를 가지는 클래스
 *
 */
public class Car {
    private static final int INIT_POSITION = 0;
    private int position;;

    public Car() {
        position = INIT_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void move(int distance) {
        this.position += distance;
    }
}
