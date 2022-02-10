package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.vo.CarResultVO;

public class Round {

    private final int roundNumber;

    public Round(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public List<CarResultVO> play(List<Car> cars) {
        List<CarResultVO> results = new ArrayList<>();

        for (Car car : cars) {
            car.moveByRule();
            results.add(new CarResultVO(car.getName(), car.getDistance()));
        }

        return results;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
