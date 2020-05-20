package step3;

import step2.StringUtil;

import java.util.*;

public class RacingGame {
    private int carCnt;
    private int time;
    private int[] carPositions;
    private String[] carNames;
    private List<Car> cars = new ArrayList<>();
    private Map<Integer, int[]> record = new HashMap<>();
    private final static int CAR_CNT_MIN = 1;
    private final static int TIME_CNT_MIN = 1;
    private int maxPosition = 0;
    private Map<Integer, List<String>> recordOfName = new HashMap<>();

    public RacingGame(int carCnt, int time) {
        this.carCnt = carCnt;
        this.time = time;
        validCarCnt();

        this.carPositions = new int[carCnt];
        initializeCars();
    }

    public RacingGame(String carName, int time) {
        carNames = StringUtil.doSplit(carName, ",");
        this.carCnt = carNames.length;
        this.time = time;
        validCarCnt();
        this.carPositions = new int[carCnt];
        initializeCarsWithName();
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

    private void initializeCarsWithName() {
        for (int i = 0; i < carCnt; i++) {
            cars.add(new Car(carNames[i]));
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
