package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.StringUtils;
import com.jaeyeonling.racingcar.view.Visualizable;

public class Car implements Visualizable {

    static final String VISUAL_POSITION_STRING = "-";
    static final int DEFAULT_POSITION = 1;

    private int position;
    private MoveStrategy moveStrategy;

    Car(final MoveStrategy moveStrategy) {
        this(DEFAULT_POSITION, moveStrategy);
    }

    Car(final int position, final MoveStrategy moveStrategy) {
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public String visualize() {
        return getVisualPosition();
    }

    void moveForward(final int condition) {
        if (moveStrategy.isMove(condition)) {
            position++;
        }
    }

    int getPosition() {
        return position;
    }

    private String getVisualPosition() {
        return StringUtils.repeat(VISUAL_POSITION_STRING, position);
    }
}
