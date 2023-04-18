package carracing.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Award {
    public void getWinner(List<Car> cars) {
        //경주순위 정렬
        sortRanking(cars);
    }

    public void sortRanking(List<Car> cars) {
        Collections.sort(cars, new CompareRank());
    }

}
