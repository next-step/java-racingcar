package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.application.dto.CarMovesResponse;
import com.nextstep.camp.racing.application.dto.LapResponse;

public class LapHistoryResult extends AbstractResult<String> {

    private final List<List<String>> laps;

    private static final String MOVE = "-";

    private LapHistoryResult(List<LapResponse> laps) {
        super(DEFAULT_VALUE);
        this.laps = laps.stream()
                .map(LapHistoryResult::getLapSnapshot)
                .collect(Collectors.toList());
    }

    private static List<String> getLapSnapshot(LapResponse lap) {
        return lap.getCarMoves().stream()
                .map(LapHistoryResult::getCarLapSnapshot)
                .collect(Collectors.toList());
    }

    private static String getCarLapSnapshot(CarMovesResponse moves) {
        return MOVE.repeat((int) moves.getMoves().stream().filter(Boolean::booleanValue).count());
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
    public String getValue() {
        return "";
    }

    @Override
    public void action() {
        // No action needed for LabHistoryResult
    }
}
