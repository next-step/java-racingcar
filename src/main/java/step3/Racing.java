package step3;

import java.util.Random;

public class Racing {
    int[] record;
    int round;

    public Racing(int[] record, int round) {
        this.record = record;
        this.round = round;
    }

    public void startGame() {
        Random random = new Random();
        for (int i = 0; i < round; i++) {
            moveCar(random);
            System.out.println("******** "+(i+1)+" 라운드 ********"); // 라운드별 구분자
            ResultView.display(record);
        }
    }

    private void moveCar(Random random) {
        for (int i = 0; i < record.length; i++) {
            moveIfNumberIsGreaterThanFour(random, i);
        }
    }

    private void moveIfNumberIsGreaterThanFour(Random random, int j) {
        if (random.nextInt(10) >= 4) {
            record[j] += 1;
        }
    }
}
