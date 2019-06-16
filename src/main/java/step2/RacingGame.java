package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int carNumber;
    private int time = 0;
    private List<Integer> carPositions;

    public void carPositionsInit(int carNumber) {
        this.carNumber = carNumber;
        carPositions = new ArrayList <>();
        while (carNumber > 0) {
            carPositions.add(1);
            carNumber--;
        }
    }

    public List <Integer> move() {
        if(time == 0){
            time++;
            return carPositions;
        }
        for (int i = 0; i < carNumber; i++) {
            int carPosition = carPositions.get(i);
            carPosition += carPositionUpdateValue();
            carPositions.set(i, carPosition);
        }
        return carPositions;
    }

    private int carPositionUpdateValue() {
        Random generator = new Random();
        int randomNumber = generator.nextInt(10);
        if (randomNumber < 4) {
            return 0;
        }
        return 1;
    }
}