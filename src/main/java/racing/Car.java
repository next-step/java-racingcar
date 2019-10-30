package racing;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import racing.movestrategies.MoveStrategy;

class Car {

    private final String name;
    private MoveStrategy moveStrategy;
    private int position;
    private Queue<Integer> records = new ArrayDeque<>();

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
        return getCopiedRecords();
    }

    private Queue<Integer> getCopiedRecords() {
        Queue<Integer> copiedRecords = new ArrayDeque<>();
        Iterator<Integer> it = records.iterator();
        while (it.hasNext()) {
            copiedRecords.add(it.next());
        }
        return copiedRecords;
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
