package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.ArrayList;
import java.util.List;

public class LapHistoryResult extends AbstractResult {

    private final List<List<String>> laps;

    private LapHistoryResult(List<CarResult> carResults) {
        super(DEFAULT_VALUE);
        List<List<String>> laps = new ArrayList<>();
        int attemptCount = carResults.get(0).getLabHistory().size();

        for (int attempt = 0; attempt < attemptCount; attempt++) {
            List<String> turnSnapshot = new ArrayList<>();
            for (CarResult carResult : carResults) {
                turnSnapshot.add(carResult.getLabHistory().get(attempt));
            }
            laps.add(turnSnapshot);
        }
        this.laps = laps;
    }

    public static LapHistoryResult of(List<CarResult> carResults) {
        return new LapHistoryResult(carResults);
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
