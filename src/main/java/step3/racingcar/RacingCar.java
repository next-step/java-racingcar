package step3.racingcar;

import java.util.Random;

public class RacingCar {

    final private Random random;
    private final int no;
    private int randomSeed = 0;
    private int position;
    private RacingCarResult roundResult;

    public RacingCar(int no) {
        this.no = no;
        this.position = 0;
        random = new Random(no);
    }

    public RacingCar(int no, int randomSeed) {
        this.no = no;
        this.position = 0;
        this.randomSeed = randomSeed;
        random = new Random(randomSeed + no);
    }

    public RacingCarResult roundResult() {
        return this.roundResult;
    }

    public int currentProgress() {
        return this.position;
    }

    public void run() {
        if (this.random.nextInt(10) >= 4) {
            this.position++;
            this.roundResult = RacingCarResult.GO;
            return;
        }
        this.roundResult = RacingCarResult.STOP;
    }

    public void show() {
        if (this.roundResult.equals(RacingCarResult.STOP)) {
            if (this.position == 0) {
                System.out.printf("Car #%d [STOP] : (%d)\n", no, position);
                return;
            }
            System.out.printf("Car #%d [STOP] : %s (%d)\n", no, "-".repeat(position), position);
        }

        if (this.roundResult.equals(RacingCarResult.GO)) {
            System.out.printf("Car #%d [ GO ] : %s (%d)\n", no, "-".repeat(position), position);
        }
    }

}
