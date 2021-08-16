package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Position;

public class RacingResult {
    private String name;
    private Position position;

    public RacingResult(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getCoordinate();
    }
}
