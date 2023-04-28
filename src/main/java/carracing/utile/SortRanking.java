package carracing.utile;

import carracing.domain.Car;

import java.util.Collections;
import java.util.List;

public class SortRanking {
    public static void sortRanking(List<Car> list) {
        Collections.sort(list, new CompareRank());
    }
}
