package study.step5.domain;

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
    private Position position;;

    public Car(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = new Position(INIT_POSITION);
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()) {
            this.position = position.move();
        }
    }
}
