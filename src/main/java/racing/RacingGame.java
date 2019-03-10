package racing;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    // 운행횟수
    private int time;
    // 이동횟수
    private int[] carPositions;

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    public void setCarPositions(int carPositions) {
        this.carPositions = new int[carPositions];
    }

    public int[] getCarPositions() {
        return this.carPositions;
    }

    // 4이상 10미만인 경우 이동횟수 + 1
    public int[] move() {
        Random random = new Random();
        for (int i = 0; i < this.carPositions.length; i++) {
            if (random.nextInt(10) >= 4) {
                carPositions[i] += 1;
            }
        }
        return carPositions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingGame rg = new RacingGame();
        rg = RacingGameInputView.setInitCar(rg, scanner);
        RacingGameResultVIew.racingResultView(rg);
    }
}