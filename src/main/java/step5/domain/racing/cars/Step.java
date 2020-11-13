package step5.domain.racing.cars;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-14.
 */
public class Step {

    private int step;

    private Step(int step) {
        this.step = step;
    }

    public static Step of(int step) {
        return new Step(step);
    }

    public int step() {
        return this.step;
    }

    public Step move(int step) {
        this.step = this.step + step;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step1 = (Step) o;
        return step == step1.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step);
    }
}
