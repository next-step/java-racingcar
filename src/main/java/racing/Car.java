package racing;

import java.util.Random;

public class Car {
    private static Random random = new Random();
    protected int position;
    StringBuilder stringBuilder;

    Car() {
        this.position = 0;
    }

    /**
     * 자동차 이동 메서드
     */
    public void move() {
        this.position += determineGoOrStop();
    }

    /**
     * 자동차 이동 여부 결정 메서드
     */
    private int determineGoOrStop() {
        int randomInt = random.nextInt(10);
        if (randomInt >= 4) {
            return 1;
        }
        return 0;
    }

    public String print() {
        stringBuilder = new StringBuilder();
        for (int i=0; i<this.position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
