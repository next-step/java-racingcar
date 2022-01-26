package racinggame.domain;

public class Car {

    private final String name;
    private int location;

    public Car(final String name) {
        this.name = name;
        this.location = 0;
    }

    public static Car of(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자를 초과할 수 없습니다.");
        }
        return new Car(name);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        this.location++;
    }
}
