package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Score {

    public static int getMax(final List<Car> carList) {
        List<Integer> scores = new ArrayList<>();

        for (Car car : carList) {
            scores.add(car.getPosition());
        }

        return Collections.max(scores);
    }

}
