package study.step5.domain;

/**
 * Car Class
 *
 * 자동차의 정보를 가지는 클래스
 *
 */
public class Car {
    private static final int INIT_POSITION = 0;
    private Name name;
    private Position position;;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INIT_POSITION);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()) {
            this.position = position.move();
        }
    }
}
