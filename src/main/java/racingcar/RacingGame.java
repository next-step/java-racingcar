package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private int time;
    private int carCount;
    private ArrayList<Racingcar> carPositions = new ArrayList<Racingcar>();

    private int GO_CONDITION_COUNT = 4;
    private int CAR_MOVE_COUNT = 1;

    public RacingGame(int carCount, int time) {
        this.time = time;
        this.carCount = carCount;
    }

    public void start() {
        validate();
        ResultView resultView = new ResultView();
        createCar();

        System.out.println("실행 결과");
        for (int i=0; i < time; i++) {
            move();
            resultView.printResult(carPositions);
        }
    }

    private void validate() {
        if (time < 0) {
            throw new IllegalArgumentException("time is not positive number");
        } else if (carCount < 0) {
            throw new IllegalArgumentException("carCount is not positive number");
        }
    }

    private void move() {
        for (Racingcar racingcar : carPositions) {
            int getPosition = racingcar.getCarMovePosition();
            if (isGo()) {
                racingcar.setCarMovePosition(getPosition + CAR_MOVE_COUNT);
            }
        }
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