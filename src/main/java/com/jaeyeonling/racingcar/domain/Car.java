package com.jaeyeonling.racingcar.domain;

import com.jaeyeonling.racingcar.utils.StringUtils;
import com.jaeyeonling.racingcar.view.Visualizable;

public class Car implements Visualizable {

    private static final String VISUALIZE_FORMAT = "%s : %s";
    static final String VISUAL_POSITION_STRING = "-";
    static final int DEFAULT_POSITION = 1;

    private final String name;
    private int position;
    private MoveStrategy moveStrategy;

    Car(final String name, final MoveStrategy moveStrategy) {
        this(name, DEFAULT_POSITION, moveStrategy);
    }

    Car(final String name, final int position, final MoveStrategy moveStrategy) {
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public String visualize() {
        return String.format(VISUALIZE_FORMAT, name, getVisualPosition());
    }

    public String getName() {
        return name;
    }

    void moveForward(final int condition) {
        if (moveStrategy.isMove(condition)) {
            position++;
        }
    }

    int getPosition() {
        return position;
    }

    boolean isMatchPosition(final int expected) {
        return position == expected;
    }

    private String getVisualPosition() {
        return StringUtils.repeat(VISUAL_POSITION_STRING, position);
    }
}
