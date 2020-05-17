package mission1.racing;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int time;
    private int carNumber;
    private int[] carPositions = {0, 0, 0};
    private Random rand = new Random();

    public void startGame() {
        setGame();

        for(int i = 0; i < time; i++) {
            move();
        }
    }

    public void move() {
        for(int i = 0; i < carPositions.length; i++) {
            carPositions[i] += moveCondition();
        }
    }

    private int moveCondition() {
        if (random() >= 4) {
            return 1;
        }

        return 0;
    }

    private void setGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        time = scanner.nextInt();
    }

    private int random() {
        int randomNum = rand.nextInt(10);

        return randomNum;
    }
}
