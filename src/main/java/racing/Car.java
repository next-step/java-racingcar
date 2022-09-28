package racing;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    private static final String ROAD = "-";

    private int location = 1;

    public void move(){
        location++;
    }

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.location, o2.location);
    }

    public String location() {
        StringBuilder result = new StringBuilder();
        result.append(ROAD.repeat(Math.max(1, location)));
        return result.toString();
    }
}
