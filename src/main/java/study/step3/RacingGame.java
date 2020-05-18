package study.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time= 0;
    private int carNumbers = 0;

    public RacingGame(int time, int carNumbers) {
        this.time = time;
        this.carNumbers = carNumbers;
    }

    public int getTryTime(){
        return time;
    }

    public int getCarNumbers() {
        return carNumbers;
    }
}
