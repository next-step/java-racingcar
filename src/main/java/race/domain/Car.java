package race.domain;

public class Car {

    private static final int FORWARD_STANDARD = 4;
    private static final int LENGTH_STANDARD = 5;
    private static final int MOVE = 1;
    private String name;
    private int position = 0;

    public Car(int position) {
        this("", position);
    }

    public Car(String name, int position) {
        if (!checkNameLength(name))
            throw new IllegalArgumentException("자동차 이름 길이는 5 이하여야 합니다.");
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean checkNameLength(String name) {
        return name.length() <= LENGTH_STANDARD;
    }

    public boolean canForward(int random) {
        return random >= FORWARD_STANDARD;
    }

    public void move() {
        this.position += MOVE;
    }

    public int getMax(int max) {
        return Math.max(max, this.position);
    }

    public boolean isSamePosition(int max) {
        return this.position == max;
    }

    public void makeForward(int random) {
        if (canForward(random)) {
            move();
        }
    }
}
