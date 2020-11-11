package racingcar.model;

import racingcar.dto.StepByCar;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private String name;
    private int position;
    private Motor motor;

    public Car(String name, Motor motor) {
        this.name = name;
        this.position = INITIAL_POSITION;
        this.motor = motor;
    }

    public void run() {
        if (motor.isMovable()) {
            move();
        }
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public StepByCar buildToStepByCar(){
        return StepByCar.of(this);
    }
}
