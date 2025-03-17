package step3.racingcar.model;

public class RacingCar {

    private final int no;
    private final RacingCarEngine carEngine;
    private int position;
    private RacingCarResult roundResult;

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

    public RacingCarResult roundResult() {
        return this.roundResult;
    }

    public void run() {
        if (carEngine.canRun()) {
            this.position++;
            this.roundResult = RacingCarResult.GO;
            return;
        }
        this.roundResult = RacingCarResult.STOP;
    }

}
