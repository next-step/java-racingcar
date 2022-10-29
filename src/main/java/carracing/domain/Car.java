package carracing.domain;

import java.util.Random;

public class Car {
    private static final int MOVABLE_NUMBER = 4;
    private static final int INIT_POSITION = 0;

    private int carId;
    private String name;
    private int position;

    public Car(final int carId, String name, int position){
        this.carId = carId;
        this.name = name;
        this.position = position;
    }

    public Car(final int carId, String name) {
        this(carId, name,INIT_POSITION);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public void move(NumberGenerator numberGenerator) {
        int number= numberGenerator.generate();
        if(number > MOVABLE_NUMBER)
            this.position++;
    }
}
