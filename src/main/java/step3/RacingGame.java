package step3;

import java.util.*;

public class RacingGame {
    private int carCnt;
    private int time;
    private int[] carPositions;
    private List<Car> cars = new ArrayList<>();
    private Map<Integer, int[]> record = new HashMap<>();
    private final static int CAR_CNT_MIN = 1;
    private final static int TIME_CNT_MIN = 1;

    public RacingGame(int carCnt, int time) {
        this.carCnt = carCnt;
        this.time = time;
        validCarCnt();

        this.carPositions = new int[carCnt];
        initializeCars();
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

    private void initializeCars(){
        for (int i = 0; i < carCnt; i++) {
            cars.add(new Car());
        }
    }

    private void validCarCnt() {
        if (carCnt < CAR_CNT_MIN || time < TIME_CNT_MIN) {
            throw new IllegalArgumentException("please check entered number, carCnt: " + carCnt + " time: " + time);
        }
    }

    private void move() {
        for(Car car : cars) {
            car.move();
        }
    }

    private void saveRecord(int round) {
        for (int i = 0; i< carCnt; i++) {
            carPositions[i] = cars.get(i).getDistance();
        }
        int[] currentPosition = Arrays.copyOf(carPositions, carPositions.length);
        record.put(round, currentPosition);
    }
}
