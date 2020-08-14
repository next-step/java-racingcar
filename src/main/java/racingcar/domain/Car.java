package racingcar.domain;

import racingcar.exception.ExceptionHandler;
import racingcar.utils.Move;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        ExceptionHandler.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(Move moveAble) {
        if(moveAble.moveAble()) {
            position++;
        }
    }
}
