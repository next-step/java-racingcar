package step5.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int MAX_LENGTH = 5;
    private static final int ZERO = 0;
    private static final int MOVE_OR_STOP_VALUE = 4;

    private String name;
    private int position = 0;
    private List<Integer> recordMove;

    public int getRecordMove(int i) {
        return recordMove.get(i);
    }

    public String getName() {
        return name;
    }

    public Car(String name) {
        validate(name);
        this.name = name;
        recordMove = new ArrayList<>();
    }

    private void validate(String name) {
        validateOfNull(name);
        validateOfLength(name);
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
        recordMove.add(position);
    }

    public boolean isMove(int movePoint) {
        return movePoint >= MOVE_OR_STOP_VALUE;
    }

    public int getPosition() {
        return position;
    }

    public boolean equalsPosition(int maxPosition) {
        return (this.position == maxPosition)? true: false;
    }
}
