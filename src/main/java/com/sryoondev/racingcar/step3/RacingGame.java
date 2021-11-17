package com.sryoondev.racingcar.step3;

public class RacingGame {
    private final int racingCount;
    private final Circuit circuit;
    private final GameRecord gameRecord;

    public RacingGame(String[] names, int racingCount) {
        this.circuit = new Circuit(names);
        this.racingCount = racingCount;
        this.gameRecord = new GameRecord();
    }

    public GameRecord start() {
        for (int i = 0; i < racingCount; i++) {
            circuit.race();
            gameRecord.add(circuit);
        }
        return gameRecord;
    }
}
