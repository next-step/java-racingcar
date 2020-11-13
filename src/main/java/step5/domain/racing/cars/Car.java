package step5.domain.racing.cars;

import step5.domain.strategy.MoveStrategy;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-04.
 * 자동차 객체
 */
public class Car {

    private final Name name;
    private Step step; //자동차가 전진한 횟수

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int step) {
        this.name = Name.of(name);
        this.step = Step.of(step);
    }

    public void forward(int step) {
        this.step.move(step);
    }

    public int getStep() {
        return this.step.step();
    }

    public String getName() {
        return name.name();
    }

    public void forward(MoveStrategy moveStrategy) {
        this.step.move(moveStrategy.move());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(step, car.step)
                && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, step);
    }
}
