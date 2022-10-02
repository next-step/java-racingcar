package com.game.racing.domain.car;

import com.game.racing.domain.generator.NumberGenerator;
import com.game.racing.domain.position.Position;
import com.game.racing.view.ResultView;

public class Car {

    public static final Integer MIN_VALUE_TO_MOVE_CAR = 4;
    private final Position position;

    private final NumberGenerator numberGenerator;
    private final String name;

    public Car(String name, NumberGenerator numberGenerator) {
        this.position = new Position();
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        moveCarByGeneratedValue();
        ResultView.printCarNameAndPosition(this);
    }

    private void moveCarByGeneratedValue() {
        if (numberGenerator.generate() >= MIN_VALUE_TO_MOVE_CAR) {
            position.add();
        }
    }
}
