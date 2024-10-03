package step4.vehicle;

import step4.util.NumberGenerator;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private int location = 1;
    private String name ;

    Car(String name){
        this.name = name;
    }

    public void move(NumberGenerator generator) {
        if (isMovable(generator.getValue())) {
            this.location++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

}
