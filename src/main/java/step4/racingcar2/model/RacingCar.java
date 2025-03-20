package step4.racingcar2.model;

public class RacingCar {

    private final int no;
    private final RacingCarEngine carEngine;
    private int position;

    public RacingCar(int no, RacingCarEngine carEngine) {
        this.no = no;
        this.carEngine = carEngine;
        this.position = 0;
    }

    public int no() {
        return this.no;
    }

    public int position() {
        return this.position;
    }

    public void run() {
        if (carEngine.canRun()) {
            this.position++;
        }
    }

}
