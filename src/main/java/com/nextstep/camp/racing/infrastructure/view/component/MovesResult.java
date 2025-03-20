package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.ArrayList;
import java.util.List;

public class MovesResult extends AbstractResult {

    private final List<Boolean> moves;

    private MovesResult(List<Boolean> moves) {
        super(DEFAULT_VALUE);
        this.moves = moves;
    }

    public static MovesResult of(List<Boolean> moves) {
        return new MovesResult(moves);
    }

    @Override
    public String getName() {
        return "movesResult";
    }

    @Override
    public String getLabel() {
        return "";
    }

    public List<String> getLabHistory() {
        List<String> labHistory = new ArrayList<>();
        int position = 0;

        for (boolean move : moves) {
            if (move) {
                position++;
            }
            labHistory.add("-".repeat(position));
        }

        return labHistory;
    }

    @Override
    public void action() {
        // No action needed for MovesResult
    }
}
