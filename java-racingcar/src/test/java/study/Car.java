package study;

import java.util.*;
import ui.ResultView;
import java.util.function.Supplier;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final StringBuilder position = new StringBuilder();
    private static final Random random = new Random();
    private final Supplier<Integer> randomSupplier;

    public Car(Supplier<Integer> randomSupplier) {
        this.randomSupplier = randomSupplier;
    }

    public void move() {
        if (randomSupplier.get()>= MOVE_THRESHOLD) {
            ResultView.printCarString(position);
        }
    }

    public String getPosition() {
        return position.toString();
    }
}
