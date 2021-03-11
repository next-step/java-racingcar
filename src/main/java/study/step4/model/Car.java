package study.step4.model;

/**
 * Car Class
 *
 * 자동차의 정보를 가지는 클래스
 *
 */
public class Car {
    private static final int INIT_POSITION = 0;
    private String name;
    private int position;;

    public Car(String name) {
        this.name = name;
		this.position = INIT_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int distance) {
        this.position += distance;
    }
}
