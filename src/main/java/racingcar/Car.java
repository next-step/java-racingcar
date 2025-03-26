package racingcar;

public class Car {
    private int position = 1;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int random) {
        if (isMovable(random)) {
            this.position++;
        }
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= 4;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
