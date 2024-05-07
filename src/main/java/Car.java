public class Car {
    private static final String DEFAULT_NAME = "";
    private int position = 1;
    private final String name;

    public Car() {
        this(DEFAULT_NAME);
    }

    public Car( String name) {
        validateName(name);

        this.name = name;
    }

    public void move(MovePolicy movePolicy) {
        if (movePolicy.isAbleToMove()) {
            this.position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int max(int value) {
        return Math.max(value, this.position);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }
}
