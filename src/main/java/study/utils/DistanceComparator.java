package study.utils;

import study.domain.Car;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getPosition() <= o2.getPosition()) {
            return 1;
        }
        return -1;
    }

}
