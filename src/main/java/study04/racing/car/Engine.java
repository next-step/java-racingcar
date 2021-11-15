package study04.racing.car;

import java.util.Random;

public class Engine {

    private final Random random = new Random();
    private final int randomBound;
    private final int engineRunBound;
    private boolean lastedRun;

    private Engine(int randomBound, int engineRunBound) {
        this.randomBound = randomBound;
        this.engineRunBound = engineRunBound;
    }

    public static Engine createEngine() {
        return createEngine(10, 4);
    }

    public static Engine createEngine(int randomBound, int engineRunBound) {
        return new Engine(randomBound, engineRunBound);
    }

    public boolean isLastedRun() {
        return lastedRun;
    }

    public boolean isRun() {
        lastedRun = random.nextInt(this.randomBound) >= this.engineRunBound;
        return this.lastedRun;
    }

}
