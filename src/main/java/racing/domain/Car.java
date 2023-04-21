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

    public int bigger(int input) {
        if (input > this.location) return input;
        return this.location;
    }

    public boolean isWinner(int winnerLocation) {
        if (this.location >= winnerLocation) return true;
        return false;
    }

    public int location() {
        return this.location;
    }

    public String name() {
        return this.name;
    }
}
