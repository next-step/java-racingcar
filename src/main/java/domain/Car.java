package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final int INITIAL_LOCATION = 1;
    private final int MOVE_CONDITION = 4;

    private String name;
    private List<Integer> locationRecord = new ArrayList<>();
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = INITIAL_LOCATION;
    }

    public void move(int condition) {
        if (condition >= MOVE_CONDITION) {
            this.location++;
        }
        saveCurrentLocation();
    }

    private void saveCurrentLocation() {
        locationRecord.add(getCurrentLocation());
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return this.location;
    }

    public List<Integer> getLocationRecord() {
        return this.locationRecord;
    }

}
