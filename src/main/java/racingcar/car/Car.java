package racingcar.car;

import racingcar.numbergenerator.NumberGenerator;

public class Car {

    private final static int MOVE_STRATEGY_NUMBER = 4;
    private int state;
    private String name;

    private Car(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public static Car from(String name){
        return new Car(0, name);
    }
    public void move(NumberGenerator numberGenerator){
        if(numberGenerator.generate() >= MOVE_STRATEGY_NUMBER){
            this.state++;
        }
    }

    public int getState(){
        return state;
    }

    public String getName() {
        return name;
    }
}
