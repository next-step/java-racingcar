package racinggame.domain;

public class Car {
    private final String name;
    private Trace trace;

    public Car(final String name) {
        this.name = name;
        this.trace = new Trace();
    }

    public String getName() {
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
