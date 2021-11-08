package racing;

/**
 * @author han
 */
public class Car {
    private int step = 0;

    public int getStep() {
        return step;
    }

    public int forward(int step) {
        if (isForward(step)) {
            this.step += 1;
        }
        return this.step;
    }

    private boolean isForward(int step) {
        return step > 4;
    }
}
