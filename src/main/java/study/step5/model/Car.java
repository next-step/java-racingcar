package study.step5.model;

/**
 * Car Class
 *
 * 자동차의 정보를 가지는 클래스
 *
 */
public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int INIT_POSITION = 0;
    private String name;
    private int position;;

    public Car(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
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
