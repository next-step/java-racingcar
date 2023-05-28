package racinggame.domain;

public class Car {
    private final Name name;
    private Trace trace;

    public Car(final Name name) {
        this.name = name;
        this.trace = new Trace();
    }

    public Name getName() {
        return this.name;
    }

    public Trace getTrace() {
        return this.trace;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove())
            trace = trace.move();
    }

    public Trace getMaxTrace(Trace maxTrace) {
        if (trace.lessThan(maxTrace.getValue())) {
            return maxTrace;
        }
        return this.trace;
    }
}
