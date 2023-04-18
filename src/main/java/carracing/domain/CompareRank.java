package carracing.domain;

import java.util.Comparator;

public class CompareRank implements Comparator {
    public int compare(Object o1, Object o2) {
        int num1 = ((Car) o1).getLocation();
        int num2 = ((Car) o2).getLocation();

        if (num1 == num2) {
            return 0;
        }
        //내림차순
        return num2 - num1;
    }
}
