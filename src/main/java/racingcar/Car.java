package racingcar;

import java.util.Random;

import static racingcar.RacingGame.LIMIT;
import static racingcar.RacingGame.RANGEOFNUM;

public class Car {
    private int curPosition;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(int curPosition) {
        this.curPosition = curPosition;
    }

    public int getCurPosition() {
        return curPosition;
    }
    public void setCurPosition(int curPosition) {
        this.curPosition += curPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int checkLimit(int currentPos) {
        if(currentPos >= LIMIT) {
            return 1;
        }
        return 0;
    }

    public void move() {
        Random rand = new Random();
        int currentPos = rand.nextInt(RANGEOFNUM);
        int resultData = checkLimit(currentPos);
    }
}
