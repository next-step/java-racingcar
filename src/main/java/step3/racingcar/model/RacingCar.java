package step3.racingcar.model;

import java.util.Random;

public class RacingCar {

    private int no;
    private int position;
    private RacingCarResult roundResult;
    final static private int BOUND = 10;
    final static private int THRESHOLD = 4;

    public RacingCar(int no) {
        this.no = no;
        this.position = 0;
    }

    public int no() {
        return this.no;
    }

    public int position() {
        return this.position;
    }

    public RacingCarResult roundResult() {
        return this.roundResult;
    }

    public boolean canGo() {
        return new Random().nextInt(BOUND) >= THRESHOLD;
    }

    public void run() {
        if (canGo()) {
            this.position++;
            this.roundResult = RacingCarResult.GO;
            return;
        }
        this.roundResult = RacingCarResult.STOP;
    }

}
