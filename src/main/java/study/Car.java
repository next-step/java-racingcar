package study;

public class Car {
    public static final int LENGTH_LIMIT = 5;

    private String name;
    private int position;

    public void move(boolean movable) {
        if (movable) {
            this.position++;
        }
    }

    public void name(String name) {
        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
