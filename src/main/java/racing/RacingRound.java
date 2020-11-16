package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingRound {

    private final List<Cars> racingRound = new ArrayList<>();

    public RacingRound(String[] names, int round) {
        List<Integer> oldPositions = new ArrayList<>();
        initOldPosition(names.length, oldPositions);

        for (int i = 0; i < round; i++) {
            racingRound.add(new Cars(names, oldPositions));
            racingRound.get(i).go();
            addOldPosition(oldPositions, i);
        }
    }

    private void initOldPosition(int participationCars, List<Integer> oldPositions) {
        for (int i = 0; i < participationCars; i++) {
            oldPositions.add(0);
        }
    }

    private void addOldPosition(List<Integer> oldPositions, int i) {
        oldPositions.clear();
        for (int j = 0; j < racingRound.get(i).size(); j++) {
            oldPositions.add(racingRound.get(i).getCar(j).getPosition());
        }
    }

    public Cars getRoundResult(int round) {
        return racingRound.get(round);
    }

    public int size() {
        return racingRound.size();
    }
}
