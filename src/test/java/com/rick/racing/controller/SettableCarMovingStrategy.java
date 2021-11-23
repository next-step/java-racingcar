package com.rick.racing.controller;

public class SettableCarMovingStrategy implements CarMovingStrategy {

    private final boolean go;

    private SettableCarMovingStrategy(boolean go) {
        this.go = go;
    }

    public static SettableCarMovingStrategy create(boolean go) {
        return new SettableCarMovingStrategy(go);
    }

    @Override
    public boolean isGo() {
        return go;
    }
}
