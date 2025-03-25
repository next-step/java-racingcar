package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.application.dto.CarResponse;
import com.nextstep.camp.racing.application.dto.RacingResponse;

public class RacingResult extends AbstractResult<String> {

    private final LapHistoryResult lapHistoryResult;
    private final List<String> winnersName;

    private static final String RACING_HEADER = "실행 결과";
    private static final String NEWLINE = "\n";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String WINNING_MESSAGE = "가 최종 우승했습니다.";

    private RacingResult(RacingResponse racing) {
        super(DEFAULT_VALUE);
        this.lapHistoryResult = LapHistoryResult.of(racing.getLaps());
        this.winnersName = racing.getWinners().stream()
                .map(CarResponse::getName)
                .collect(Collectors.toList());
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
        display.append(NEWLINE)
                .append(String.join(WINNER_NAME_DELIMITER, winnersName))
                .append(WINNING_MESSAGE);
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
    public String getValue() {
        return "";
    }

    @Override
    public void action() {
        System.out.println(getDisplay());
    }
}
