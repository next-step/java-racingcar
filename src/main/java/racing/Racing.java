package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final Round round;
    private final List<RoundResult> results;

    public Racing(RacingInfo info){
        cars = info.getCars();
        round = info.getRound();
        results = new ArrayList<>();
    }

    public void race() {
        int roundNumber = round.getRoundNumber();

        while (roundNumber-- > 0) {
            final RoundResult result = round.play(cars);
            results.add(result);
        }
        printResult();
    }

    private void printResult() {
        for(RoundResult result : results) {
            System.out.println(result.getStringResult());
        }
    }

    public List<Car> getLastResult() {
        final int LAST_INDEX = results.size() - 1;
        return results.get(LAST_INDEX).getCars();
    }
}
