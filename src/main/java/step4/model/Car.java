package step4.model;

public class Car {

    private String name;
    public static final int MAX_LENGTH = 5;
    public static final int ZERO = 0;
    private int position = 0;
    public static final int MOVE_OR_STOP_VALUE = 4;

    public String getName() {
        return name;
    }

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateOfLength(name);
        validateOfNull(name);
    }

    private void validateOfLength(String name) {
        if (name.length() > MAX_LENGTH || name.trim().length() == ZERO) {
            throw new IllegalArgumentException("****** Name length error!!");
        }
    }

    private void validateOfNull(String name) {
        if (name == null) {
            throw new NullPointerException("널값은 입력할 수 없습니다.");
        }
    }

    public void move(int movePoint) {
        if (isMove(movePoint)) {
            this.position++;
        }
    }

    public boolean isMove(int movePoint) {
        return movePoint >= MOVE_OR_STOP_VALUE;
    }

    public int getPosition() {
        return position;
    }
}
