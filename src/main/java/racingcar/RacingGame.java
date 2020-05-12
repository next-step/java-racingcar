package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private int time;
    private int carCount;
    private ArrayList<Racingcar> carPositions = new ArrayList<Racingcar>();

    private int GO_CONDITION_COUNT = 4;

    public RacingGame(int carCount, int time) {
        this.time = time;
        this.carCount = carCount;
    }

    public ArrayList<Racingcar> move() {

        return null;
    }

    private Boolean isGo() {
        Random random = new Random();
        return random.nextInt(10) > GO_CONDITION_COUNT;
    }

    private void createCar() {
        Racingcar racingcar;
        for (int i = 0; i < carCount; i++) {
            racingcar = new Racingcar(i);
            carPositions.add(racingcar);
        }
    }

}