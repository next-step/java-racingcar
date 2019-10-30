package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private List<Integer> positionList = new ArrayList<>();

    public void move() {
        int lastTrial = positionList.size();
        int position = 0;

        if (lastTrial > 0) {
            position = positionList.get(lastTrial - 1);
        }

        if (getRandom() > 3) {
            position += 1;
        }

        positionList.add(position);
    }

    public int getCarPosition(int roundNum) {
        return positionList.get(roundNum);
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }


}
