package com.rick.racing.controller;

public class SettableCarMovingStrategy implements CarMovingStrategy {

    private boolean go;

    private SettableCarMovingStrategy() {
    }

    public static SettableCarMovingStrategy create() {
        return new SettableCarMovingStrategy();
    }

    @Override
    public boolean isGo() {
        return go;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

}
