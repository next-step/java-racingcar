package racingcar.racing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameRepository {
    private static final Map<Integer, RacingCar> store = new HashMap<>();

    public void save(RacingCar racingCar) {
        store.put(racingCar.getId(), racingCar);
    }

    public List<RacingCar> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
