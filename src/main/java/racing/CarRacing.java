package racing;

import racing.domain.Grid;
import java.util.LinkedList;

public class CarRacing {

    private int cars = 0;
    private int rounds = 0;

    public CarRacing(int cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public Grid start() {
        return new Grid(new LinkedList<>())
                .lineUp(this.cars)
                .standingStart(this.rounds);
    }
}
