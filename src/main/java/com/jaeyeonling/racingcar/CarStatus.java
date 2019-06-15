package com.jaeyeonling.racingcar;

import com.jaeyeonling.racingcar.utils.StringUtils;

public class CarStatus implements Visualizable {

    private static final String VISUAL_POSITION_STRING = "-";

    private int position;

    CarStatus(final Car car) {
        position = car.getPosition();
    }

    @Override
    public String visualize() {
        return getVisualPosition();
    }

    private String getVisualPosition() {
        return StringUtils.repeat(VISUAL_POSITION_STRING, position);
    }
}
