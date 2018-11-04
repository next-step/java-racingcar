package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int position;
    private static final int MOVING_STANDARD_VALUE = 4;
    private List<Integer> myRecords;

    public Car() {
        this.position = 0;
        this.myRecords = new ArrayList<>();
    }

    public int getPosition() {
        return this.position;
    }

    public void addPosition(int randomValue) {
        if (randomValue < MOVING_STANDARD_VALUE) {
            return;
        }
        ++position;
    }

    public void record(int position) {
        myRecords.add(position);
    }

    public List getRecord() {
        return myRecords;
    }
}
