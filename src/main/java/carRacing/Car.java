package carRacing;


public class Car {

    public static final int NAME_MIN_LENGTH = 1;
    public static final int NAME_MAX_LENGTH = 5;

    private Position position;
    private String name;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) {
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 ~ 5자 사이여야 합니다.");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void go(CarMovingStrategy carMovingStrategy) {
        if (carMovingStrategy.isMove()) {
            position = position.move();
        }
    }

    public Position max(Position maxPosition) {
        return position.max(maxPosition);
    }

    public boolean isEqualPosition(Position compareToPosition) {
        return this.position.equals(compareToPosition);
    }

    public String toStringPosition() {
        return name + " : " + position.toStringPosition();
    }
}
