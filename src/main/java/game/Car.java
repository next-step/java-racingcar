package game;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public String name;

    public int maxPosition;

    public List<Position> position;

    public Car(String name) {
        this.name = name;
        this.position = new ArrayList<Position>();
    }

    public Car(String name, int maxPosition, List<Position> position) {
        this.name = name;
        this.maxPosition = maxPosition;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public List<Position> getPosition() {
        return position;
    }

    public void addPosition(Position resultPosition) {
        if (position == null) {
            position = new ArrayList<>();
        }
        position.add(resultPosition);
    }

    public void setMaxPosition(int currentPosition) {
        this.maxPosition = Math.max(this.maxPosition, currentPosition);
    }

    public static Car create(String name){
        return new Car(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxPosition=" + maxPosition +
                ", position=" + position +
                '}';
    }
}
