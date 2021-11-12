package carracingwinner.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_BOUND = 4;

    private String name;
    private Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public void move(int random) {
        if (random >= MOVE_BOUND) {
            position.increase();
        }
    }

    public String showCurrentState() {
        return name + " : " + position.getStringValue();
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

}
