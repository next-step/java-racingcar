package study.step4.domain;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o2.position() - o1.position();
    }
}
