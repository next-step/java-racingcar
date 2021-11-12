package com.sryoondev.racingcar;


import java.util.ArrayList;

public class Route {
    private final ArrayList<String> lines;

    public Route() {
        this.lines = new ArrayList<>();
    }

    public void moveForward() {
        lines.add("-");
    }

    public int getMoveCount() {
        return lines.size();
    }

    public String printLines() {
        return String.join("", lines);
    }
}
