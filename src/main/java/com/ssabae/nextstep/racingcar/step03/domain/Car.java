package com.ssabae.nextstep.racingcar.step03.domain;

import com.ssabae.nextstep.racingcar.step03.exception.CarNameInvalidException;
import com.ssabae.nextstep.racingcar.step03.validate.Validator;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public class Car {

    private static final Validator<String> validator = new CarNameValidator();
    private final String name;
    private int moveCount;

    public Car(String name) {
        if (!validator.isValid(name)) {
            throw new CarNameInvalidException();
        }
        this.name = name;
    }

    public void move(MoveState state) {
        if (state == MoveState.GO) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public String getPrintString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s : ", this.name));
        for (int i = 0; i < moveCount; i++) {
            output.append("-");
        }
        return output.toString();
    }
}
