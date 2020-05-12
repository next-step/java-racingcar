package racingcar;

import java.util.ArrayList;

public class RacingGame {
    private int time;
    private int carCount;
    private ArrayList<Racingcar> carPositions = new ArrayList<Racingcar>();

    public RacingGame(int carCount, int time) {
        this.time = time;
        this.carCount = carCount;
    }

    public ArrayList<Racingcar> move() {

        return null;
    }

    private void createCar() {
        Racingcar racingcar;
        for (int i = 0; i < carCount; i++) {
            racingcar = new Racingcar(i);
            carPositions.add(racingcar);
        }
    }

}