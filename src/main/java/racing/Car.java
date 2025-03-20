package racing;

import java.util.Random;
import java.util.function.BooleanSupplier;

import static racing.CarFactory.randomMoveConditionSupplier;

public class Car {
    private String name;

    private int position = 1;
    BooleanSupplier moveConditionSupplier;
    
    public Car(String name) {
        this(name, randomMoveConditionSupplier);
    }

    public Car(String name, BooleanSupplier moveConditionSupplier) {
        this.name = name;
        this.moveConditionSupplier = moveConditionSupplier;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (this.moveConditionSupplier.getAsBoolean()) {
            this.position += 1;
        }
    }
}
