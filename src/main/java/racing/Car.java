package racing;

import java.util.LinkedList;
import java.util.Queue;
import racing.movestrategies.MoveStrategy;

class Car {
    private MoveStrategy moveStrategy;
    private int position;
    private Queue<Integer> records = new LinkedList<>();
    private final String name;

    Car(MoveStrategy moveStrategy, String name) {
        this.moveStrategy = moveStrategy;
        this.name = name;
        this.position = 0;
    }

    int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    Queue<Integer> getRecords() {
        return records;
    }

    boolean isPositioned(int position) {
        return this.position == position;
    }

    void move() {
        if (moveStrategy.canIMove()) {
            this.position += 1;
        }
        records.offer(this.position);
    }
}
