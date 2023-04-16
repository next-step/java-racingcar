package carrace;

public class Car {
    private static final int START_POSITION = 0;
    private static final int ZERO_INDEX = 0;
    private static final int LIMIT_NAME_LENGTH = 5;
    private static final String DEFAULT_DRIVER_NAME = "CAR_";
    private String name;
    private int position;

    public Car(int index, String name) {
        name = getNameOrDefault(name, index);
        validateName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    Car(String name) {
        name = getNameOrDefault(name, ZERO_INDEX);
        validateName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    Car(int position) {
        this.name = DEFAULT_DRIVER_NAME;
        this.position = position;
    }

    private String getNameOrDefault(String name, int index) {
        name = name.trim();
        if (name == null || name.isEmpty()) {
            return DEFAULT_DRIVER_NAME + index;
        }
        return name;
    }

    private void validateName(String name) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(boolean movable) {
        if (movable) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
