package fourstep.logic;


import java.util.ArrayList;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private String name;
    private int location = 0;
    private ArrayList<Integer> roundRecords = new ArrayList<>();

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            location += 1;
        }
        roundRecords.add(location);
    }

    public boolean isMaxLocation(int maxLocation) {
        return this.location == maxLocation;
    }

    public int maxLocation(int maxLocation) {
        if (this.location > maxLocation) {
            return this.location;
        }
        return maxLocation;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public int getRoundRecord(int round) {
        return roundRecords.get(round);
    }
}

