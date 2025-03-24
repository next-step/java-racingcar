package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.List;

import com.nextstep.camp.racing.application.dto.RacingResponse;

public class RacingResult extends AbstractResult {

    private final LapHistoryResult lapHistoryResult;

    private static final String RACING_HEADER = "실행 결과";
    private static final String NEWLINE = "\n";

    private RacingResult(RacingResponse racing) {
        super(DEFAULT_VALUE);
        this.lapHistoryResult = LapHistoryResult.of(racing.getLaps());
    }

    public static RacingResult create(RacingResponse racing) {
        return new RacingResult(racing);
    }

    public String getDisplay() {
        StringBuilder display = new StringBuilder(RACING_HEADER);
        appendLapsResult(display);
        return display.toString();
    }

    private void appendLapsResult(StringBuilder display) {
        lapHistoryResult.getLaps().forEach(lab -> {
            display.append(NEWLINE);
            appendSingleLapResult(lab, display);
        });
    }

    private static void appendSingleLapResult(List<String> lab, StringBuilder display) {
        lab.forEach(move -> display.append(move).append(NEWLINE));
    }

    @Override
    public String getName() {
        return "racingResult";
    }

    @Override
    public String getLabel() {
        return "";
    }

    @Override
    public void action() {
        System.out.println(getDisplay());
    }
}
