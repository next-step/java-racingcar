package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> winnerList = new ArrayList<>();

    public List<String> winners() {
        return winnerList;
    }

    public void add(Car car, int maxDistance) {
        if (car.distance() == maxDistance) {
            winnerList.add(car.name());
        }
    }

}
