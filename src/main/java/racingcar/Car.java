package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private static final int RANDOM_BOUND = 10;
    private static final int PROCEED_THRESHOLD = 4;
    private static final int INIT_POSITION = 1;

    private final Random random = new Random();
    private final List<Integer> positions;

    Car(int trialCount) {
        positions = new ArrayList<>();
        int position = INIT_POSITION;
        for(int i=0; i< trialCount; i++) {
            addPosition(position);
            position += proceedOrStop();
        }
    }

    Car(List<Integer> positions) {
        this.positions = new ArrayList<>(positions);
    }

    public int getTrialCount() {
        return positions.size();
    }

    public int getPosition(int index) {
        return positions.get(index);
    }

    private void addPosition(int position) {
        positions.add(position);
    }

    public int proceedOrStop() {
        int randomValue = random.nextInt(RANDOM_BOUND);
        return randomValue >= PROCEED_THRESHOLD ? 1 : 0;
    }
}
