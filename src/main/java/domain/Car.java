package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final int MOVE_CONDITION = 4;

    private List<Integer> locationRecord;
    private int position;

    public Car() {
        this.position = 1;
        this.locationRecord = new ArrayList<>();
    }

    public void move(int condition) {
        if (condition >= MOVE_CONDITION) {
            this.position++;
        }
        saveCurrentPosition();
    }

    public int getCurrentPosition() {
        return this.position;
    }

    public List<Integer> getLocationRecord() {
        return this.locationRecord;
    }

    private void saveCurrentPosition() {
        locationRecord.add(getCurrentPosition());
    }


}
