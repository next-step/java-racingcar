package carracing.domain;

import java.util.Comparator;

public class CompareRank implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        int num1 = car1.getLocation();
        int num2 = car2.getLocation();
        //내림차순
        return num2 - num1;
    }
}
