package racingcar.model;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        move(new RandomRunnable());
    }

    private void move(RandomRunnable randomRunnable) {
        if (randomRunnable.isRunnable()) {
            position++;
        }
    }

    public boolean isWinner(int maxPositionValue) {
        return this.position == maxPositionValue;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}