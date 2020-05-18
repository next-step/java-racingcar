package step3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RacingGame {
    private int carCnt;
    private int time;
    private int[] carPositions;
    private List<Car> cars = new ArrayList<>();
    private HashMap<Integer, int[]> record = new HashMap<>();
    private final static int MIN_CNT = 1;

    public RacingGame(int carCnt, int time) {
        this.carCnt = carCnt;
        this.time = time;
        validCarCnt();

        this.carPositions = new int[carCnt];
        for (int i = 0; i < carCnt; i++) {
            cars.add(new Car());
        }
    }

    public void racingStart() {
        for (int i = 0; i < time; i++) {
            move();
            saveRecord(i);
        }
    }

    public void printRacing() {
        ResultView resultView = new ResultView();
        resultView.printTitle();
        for (int i = 0; i < time; i++) {
            resultView.printRoundCarPosition(record.get(i));
        }
    }

    public int[] getCarPositions() {
        return carPositions;
    }

    private void validCarCnt() {
        if (carCnt < MIN_CNT || time < MIN_CNT) {
            throw new IllegalArgumentException("please check entered number, carCnt: " + carCnt + " time: " + time);
        }
    }

    private void move() {
        for (int i = 0; i < carCnt; i++) {
            cars.get(i).move();
            carPositions[i] = cars.get(i).getDistance();
        }
    }

    private void saveRecord(int round) {
        int[] currentPosition = Arrays.copyOf(carPositions, carPositions.length);
        record.put(round, currentPosition);
    }
}
