package step3;

import java.util.ArrayList;

public class RacingGame {
    private int carCnt;
    private int time;
    private int[] carPositions;
    private Car car = new Car();
    private ArrayList<Car> cars = new ArrayList<>();

    public RacingGame(int carCnt, int time) {
        if (validCarCnt(carCnt, time)) {
            this.carCnt = carCnt;
            this.time = time;
            this.carPositions = new int[carCnt];
        }
    }

    public void run() {
        ResultView resultView = new ResultView();
        resultView.printTitle();
        for (int i = 0; i < time; i++) {
            resultView.printRoundCarPosition(move());
        }
    }

    public int[] getCarPositions() {
        return carPositions;
    }

    public static boolean validCarCnt(int carCnt, int time) {
        if (carCnt <= 0 || time <= 0)
            throw new IllegalArgumentException("please check entered number, carCnt: " + carCnt + " time: " + time);
        return true;
    }

    private int[] move() {
        for (int i = 0; i < carCnt; i++) {
            carPositions[i] = car.decideForward() ? carPositions[i] + 1 : carPositions[i];
        }
        return carPositions;
    }
}
