package racingcar;

import java.util.Random;

import static racingcar.RacingGameStatusViewer.showRacingGameStatus;

public class RacingGame {
    private int time;
    private int[] carPosition;
    private int cars;

    public RacingGame(int time, int cars) {
        this.time = time;
        this.cars = cars;
        this.carPosition = new int[cars];
    }

    public void move() {
        for (int i = 0; i < time; i++) {
            getMovePower();
            showRacingGameStatus(this.carPosition);
        }
    }

    public void getMovePower() {
        for (int car = 0; car < this.cars; car++) {
            determineMoveOrNot(car);
        }
    }

    //전진할지 여부 판단
    public void determineMoveOrNot(int car) {
        Random random = new Random();
        int power = random.nextInt(10);

        if (power >= 4) {
            this.carPosition[car] = this.carPosition[car] + 1;
        }
    }

    //TODO: Test를 위해 getter를 만들었는데, 그래도 되는건가요?
    public int getTime() {
        return time;
    }

    public int[] getCarPosition() {
        return carPosition;
    }

    public int getCars() {
        return cars;
    }
}

