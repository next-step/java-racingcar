package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private final List<Car> cars;
    private final int round;

    public Competition(int unit, int round) {
        cars = new ArrayList<>(unit);
        for (int i = 0; i < unit; i++) {
            cars.add(i, new Car());
        }

        this.round = round;
    }

    public void progressCompetition() {
        for (int i = 0; i < round; i++) {
            progressEachRound();
        }
    }

    private void progressEachRound() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).accumulateOneLap();
        }

        printRoundStatus();
    }

    private void printRoundStatus() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).printCarStatus();
            System.out.println();
        }
        System.out.println();
    }
}
