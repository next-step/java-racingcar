package step3.application.domain;

import java.util.ArrayList;
import java.util.List;


public class CarGroup {

    private final List<Car> racingGroup = new ArrayList<>();

    public List<Car> queryRacingGroup() {
        return racingGroup;
    }

    public void createGroup(int count) {
        for (int i = 0; i < count; i++) {
            racingGroup.add(new Car(i));
        }
    }
}
