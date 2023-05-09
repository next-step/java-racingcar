package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private static final int RANDOM_BOUND = 10;
    private static final int PROCEED_THRESHOLD = 4;
    private static final int INIT_POSITION = 1;

    private final Random random = new Random();

    private final String name;
    private final List<Integer> positions;

    Car(String name, int trialCount) {
        this.name = name;
        positions = new ArrayList<>();
        int position = INIT_POSITION;
        for(int i=0; i< trialCount; i++) {
            addPosition(position);
            position += proceedOrStop();
        }
    }

    Car(String name, List<Integer> positions) {
        validateCarName(name);
        this.name = name;
        this.positions = new ArrayList<>(positions);
    }

    private void validateCarName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public int getTrialCount() {
        return positions.size();
    }

    public int getPosition(int index) {
        return positions.get(index);
    }

    public int getLastPosition() {
        if(positions.isEmpty())
            return -1;

        return positions.get(positions.size() - 1);
    }

    private void addPosition(int position) {
        positions.add(position);
    }

    public int proceedOrStop() {
        int randomValue = random.nextInt(RANDOM_BOUND);
        return randomValue >= PROCEED_THRESHOLD ? 1 : 0;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
