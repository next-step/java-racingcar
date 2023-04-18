package racing.domain;

public class Car {
    private int location;
<<<<<<< HEAD
    private String name;

    private static final int NAME_MAX_LENGTH = 5;
=======
>>>>>>> e356fab2c (refactor Car 클래스를 필드로 가지는 일급컬렉션 추가)

    public Car(int location) {
        this.location = location;
    }

<<<<<<< HEAD
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
=======
    public Car move(int distance) {
        this.location += distance;
        return new Car(this.location);
    }

    public int location() {
        return this.location;
    }
>>>>>>> e356fab2c (refactor Car 클래스를 필드로 가지는 일급컬렉션 추가)
}
