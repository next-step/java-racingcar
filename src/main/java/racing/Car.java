package racing;

/**
 * @author han
 */
public class Car {
    private int step = 0;

    public Car() {
    }

    public Car(int step) {
        this.step = step;
    }

    public int getStep() {
        return this.step;
    }

    public Car getInstanceByForward(int step) {
        if (isForward(step)) {
            this.step = Math.addExact(this.step, 1);
        }
        return new Car(this.step);
    }

    private boolean isForward(int step) {
        return step > 4;
    }
}
