package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.ArrayList;
import java.util.List;

public class LabHistoryResult extends AbstractResult {

    private final List<List<String>> labs;

    private LabHistoryResult(List<CarResult> carResults) {
        super(DEFAULT_VALUE);
        List<List<String>> labs = new ArrayList<>();
        int attemptCount = carResults.get(0).getLabHistory().size();

        for (int attempt = 0; attempt < attemptCount; attempt++) {
            List<String> turnSnapshot = new ArrayList<>();
            for (CarResult carResult : carResults) {
                turnSnapshot.add(carResult.getLabHistory().get(attempt));
            }
            labs.add(turnSnapshot);
        }
        this.labs = labs;
    }

    public static LabHistoryResult of(List<CarResult> carResults) {
        return new LabHistoryResult(carResults);
    }

    public List<List<String>> getLabs() {
        return labs;
    }

    @Override
    public String getName() {
        return "labHistory";
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
