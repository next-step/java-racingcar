package carracing.domain;

public class Car {
    private int location;
    private final String name;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
        this.location = 0;
    }

    public Car(String name, int location) {
        checkNameLength(name);
        this.name = name;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void move() {
        location++;
    }

    private void checkNameLength(String carName) {
        if(carName.length() > 5) {
            throw new RuntimeException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
