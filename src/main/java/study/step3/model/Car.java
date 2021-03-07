package study.step3.model;

/**
 * Car Class
 *
 * 자동차의 정보를 가지는 클래스
 *
 */
public class Car {
    private int position = 0;

    public Car() {
    }

    public int getPosition() {
        return position;
    }

    public void move(int distance) {
        this.position += distance;

    }
}
