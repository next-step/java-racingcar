package racing.domain;

import java.util.List;

/**
 * @author : 0giri
 * @since : 2023/04/18
 */
public class RacingResult {

    private final List<Car> carList;

    public RacingResult(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> carList() {
        return this.carList;
    }
}
