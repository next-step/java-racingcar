package racinggame;

public class Car {
    public static final int MOVE_STANDARD = 4;
    private int location = 0;
    private String name;

    public Car() {

    }

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.location = getLocation();
    }

    public int move(int numberValue) {
        if (numberValue >= MOVE_STANDARD) {
            return ++location;
        }
        return location;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

}
