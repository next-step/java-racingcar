package com.cheolhyeonpark.step4.domain;

public class StopStrategy implements MovingStrategy {

    @Override
    public boolean isMovable() {
        return false;
    }
}
