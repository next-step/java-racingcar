package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundCars extends ArrayList<Cars> {
    private List<Cars> roundCars = new ArrayList<>();

    public List<Cars> getRoundCars() {
        return roundCars;
    }

    public void setRound(Cars cars) {
        this.roundCars.add(cars);
    }
}
