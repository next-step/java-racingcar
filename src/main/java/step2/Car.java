package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private List<Integer> positions = new ArrayList<>();

    public void move() {
        int lastTrial = positions.size();
        int position = 0;

        if (lastTrial > 0) {
            position = positions.get(lastTrial - 1);
        }

        if (getRandom() > 3) {
            position += 1;
        }

        positions.add(position);
    }

    public int getCarPosition(int roundNum) {
        return positions.get(roundNum);
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }


}
