package racinggame.winner;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.position = position;
    }

    public void move(int randomNum) {
        if (randomNum < 4) {
            return;
        }

        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
