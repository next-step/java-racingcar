package com.sryoondev.racingcar.step3;

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

    public String getLines() {
        return String.join("", lines);
    }
}
