package new_racingcar;

import java.util.ArrayList;
import java.util.List;

public class GrandPrix {
    private Cars cars;
    private List<Round> rounds = new ArrayList<>();

    private int roundCount;

    public GrandPrix(int playerCount, int roundCount) {
        this.cars = new Cars(playerCount);
        this.roundCount = roundCount;
    }

    public List<Round> start() {
        for(int i = 0; i < roundCount; i++) {
            rounds.add(cars.run());
        }

        return rounds;
    }
}
