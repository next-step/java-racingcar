package com.nextstep.camp.racing.infrastructure.view.component;

import com.nextstep.camp.racing.application.dto.LapResponse;
import com.nextstep.camp.racing.application.dto.MovesResponse;

import java.util.List;
import java.util.stream.Collectors;

public class LapHistoryResult extends AbstractResult {

    private final List<List<String>> laps;

    private static final String MOVE = "-";

    private LapHistoryResult(List<LapResponse> laps) {
        super(DEFAULT_VALUE);
        this.laps = laps.stream()
                .map(LapHistoryResult::getLapSnapshot)
                .collect(Collectors.toList());
    }

    private static List<String> getLapSnapshot(LapResponse lap) {
        return lap.getAllMoves().stream()
                .map(LapHistoryResult::getCarLapSnapshot)
                .collect(Collectors.toList());
    }

    private static String getCarLapSnapshot(MovesResponse moves) {
        return MOVE.repeat((int) moves.getValues().stream().filter(Boolean::booleanValue).count());
    }

    public static LapHistoryResult of(List<LapResponse> laps) {
        return new LapHistoryResult(laps);
    }

    public List<List<String>> getLaps() {
        return laps;
    }

    @Override
    public String getName() {
        return "lapHistory";
    }

    @Override
    public String getLabel() {
        return "";
    }

    @Override
    public void action() {
        // No action needed for LabHistoryResult
    }
}
