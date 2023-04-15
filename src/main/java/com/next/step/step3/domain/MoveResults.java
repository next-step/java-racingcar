package com.next.step.step3.domain;

import java.util.List;

public class MoveResults {

    private final List<MoveResult> moveResults;

    private final Winner winner;

    public MoveResults(List<MoveResult> moveResults, Cars cars) {
        this.moveResults = moveResults;
        this.winner = new Winner(cars);
    }

    public List<String> getWinnerNames() {
        return this.winner.getWinnerNames();
    }

    public List<MoveResult> getMoveResults() {
        return moveResults;
    }
}
