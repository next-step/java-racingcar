package racing;

import java.util.LinkedList;
import java.util.Queue;
import racing.movestrategies.MoveStrategy;

class Car {
    private MoveStrategy moveStrategy;
    private int position;
    private Queue<Integer> records = new LinkedList<>();

    Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.position = 0;
    }

    int getPosition() {
        return position;
    }

    Queue<Integer> getRecords() {
        return records;
    }

    void move() {
        if (moveStrategy.canIMove()) {
            this.position += 1;
        }
        records.offer(this.position);
    }
}
