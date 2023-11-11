package com.racing.game.entity;

public class RacingGame {
    private final Circuit circuit;

    public RacingGame(Circuit circuit) {
        this.circuit = circuit;
    }

    public void race() {
        circuit.startRace();
    }

}
