package step3.model;

import step3.view.Visitable;
import step3.view.Visitor;

import java.util.stream.IntStream;

public class Car implements Visitable {

    private static final int INITIAL_DISTANCE = 0;
    private static final String STEP = "-";
    private int distance;

    public Car() {
        this.distance = INITIAL_DISTANCE;
    }

    public void move(Fuel fuel) {
        if(fuel.isMovable()) {
            distance++;
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getStep() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(INITIAL_DISTANCE, distance)
                .forEach(i -> stringBuilder.append(STEP));
        return stringBuilder.toString();
    }


}
