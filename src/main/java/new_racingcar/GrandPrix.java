package new_racingcar;

import java.util.ArrayList;
import java.util.List;

public class GrandPrix {

    private ResultView resultView;
    private Cars cars;
    private List<Round> rounds = new ArrayList<>();

    private int roundCount;

    public GrandPrix(int playerCount, int roundCount) {
        this.resultView = new ResultView();
        this.cars = new Cars(playerCount);
        this.roundCount = roundCount;
    }

    public void start() {
        resultView.printGameStart();

        for(int i = 0; i < roundCount; i++) {
            rounds.add(cars.run());
        }

        resultView.printGrandPrixRecords(rounds);
    }
}
