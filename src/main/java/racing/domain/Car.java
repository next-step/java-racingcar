package racing.domain;

public class Car {
    private int location;
    private String name;

    private static final int NAME_MAX_LENGTH = 5;

    public Car(int location) {
        this.location = location;
    }
    public Car(int location, String name) {
        this.location = location;
        this.name = nameValidation(name);
    }

    public String nameValidation(String input) {
        if (input.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        return input;
    }

    public Car move(int distance) {
        this.location += distance;
        return new Car(this.location, this.name);
    }

    public int location() {
        return this.location;
    }

    public String showName() { return this.name; }
}
