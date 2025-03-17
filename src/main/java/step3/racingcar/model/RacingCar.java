package step3.racingcar.model;

public class RacingCar {

    private int no;
    private int position;
    private RacingCarEngine engine;
    private RacingCarResult roundResult;
    final static private int THRESHOLD = 4;

    public RacingCar(int no, RacingCarEngine engine) {
        this.no = no;
        this.engine = engine;
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
        if (engine.canRun()) {
            this.position++;
            this.roundResult = RacingCarResult.GO;
            return;
        }
        this.roundResult = RacingCarResult.STOP;
    }

}
