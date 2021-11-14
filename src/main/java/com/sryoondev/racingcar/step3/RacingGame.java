package com.sryoondev.racingcar.step3;

public class RacingGame {
    private final int racingCount;
    private final Circuit circuit;
    private final GameRecord gameRecord;

    public RacingGame(int carCount, int racingCount) {
        this.circuit = new Circuit(carCount);
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
