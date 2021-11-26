package study.racinggame.domain.car;

public class Car {
    public static final int LENGTH_LIMIT = 5;

    private final String name;
    private int position;

    public Car(String name, int position) {
        if (name.length() < 1 || name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public void move(boolean movable) {
        if (movable) {
            this.position++;
        }
    }

    public boolean isWinner(int max) {
        return this.position == max;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
