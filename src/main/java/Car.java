public class Car {
    private static final String DEFAULT_NAME = "";
    private int position = 1;
    private final MovePolicy movePolicy;
    private final String name;

    public Car(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
        this.name = DEFAULT_NAME;
    }

    public Car(MovePolicy movePolicy, String name) {
        validateName(name);

        this.movePolicy = movePolicy;
        this.name = name;
    }

    public void move() {
        if (this.movePolicy.isAbleToMove()) {
            this.position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
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
