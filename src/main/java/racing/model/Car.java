package racing.model;

import java.util.Random;

public class Car {
    private static final int BOUNDARY_NUMBER = 3;
    private static final String HYPHEN = "-";

    private int score;
    private String position;

    public Car() {
        this.score = 0;
    }

    public void move() {
        if (isGoing()) {
            this.score++;
        }
    }

    protected boolean isGoing() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber > BOUNDARY_NUMBER;
    }

    public String getPosition() {
        this.position = HYPHEN.repeat(this.score);
        return this.position;
    }

    /**
     * Test Code 작성을 위한 getter() 메서드
     */
    public int getScore() {
        return this.score;
    }
}
