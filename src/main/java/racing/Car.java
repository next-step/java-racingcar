package racing;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    private int location;

    public void move(){
        location++;
    }

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.location, o2.location);
    }
}
