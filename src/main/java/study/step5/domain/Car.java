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
        this(name, INIT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
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

    public Position getMaxPosition(Position maxPosition) {
        if(this.position.lessThan(maxPosition)) {
            return maxPosition;
        }
        return this.position;
    }
}
