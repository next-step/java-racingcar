package study.step4.domain;

import study.step4.move.MoveStrategy;

public class Car {

    private int position = 1;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
    public void move(MoveStrategy moveStrategy){
        if (moveStrategy.isSuccess()) {
            this.position += 1;
        }
    }

}
