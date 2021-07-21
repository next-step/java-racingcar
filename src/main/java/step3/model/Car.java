package step3.model;

import step3.App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private final List<Integer> moveRecord = new ArrayList<>(Collections.singletonList(0));

    public void moveIf(int num) {
        validateNumber(num);
        move(num);
    }

    public void move(int num) {
        moveRecord.add(now() + moveDistance(num));
    }

    public int now() {
        return moveRecord.get(moveRecord.size() - 1);
    }

    private int moveDistance(int num) {
        return num >= App.CRITERION_NUMBER ? 1 : 0;
    }

    private void validateNumber(int num) {
        if (num > App.RANGE_MAX || num < App.RANGE_MIN) throw new IndexOutOfBoundsException();
    }

    public int getPointOfTime(int time) {
        return moveRecord.get(time);
    }
}
