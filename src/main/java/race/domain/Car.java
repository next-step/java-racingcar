package race.domain;

public class Car {

    private Position position;
    private final String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this(new Position(position), name);
    }

    public Car(Position position, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("공백없이 정확한 이름을 입력해주세요.");
        }
        this.position = position;
        this.name = name;
    }


    public int getPosition() {
        return this.position.getNumber();
    }

    public String getName() {
        return name;
    }

    public void go() {
        this.position.increase();
    }

    public int maxComparedTo(int otherNumber) {
        return this.position.maxComparedTo(otherNumber);
    }

    public boolean isWinner(int maxNumber) {
        return this.position.isWinner(maxNumber);
    }

}
