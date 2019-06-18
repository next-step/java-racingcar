package com.jaeyeonling.racingcar.view;

import com.jaeyeonling.racingcar.domain.Car;
import com.jaeyeonling.racingcar.domain.RacingGameOption;
import com.jaeyeonling.racingcar.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class VisualRecorder implements Visualizable {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String VICTOR_MESSAGE = "%s가 최종 우승했습니다.";

    private final StringBuilder recorder = new StringBuilder();

    public void recodeResultMessage() {
        newLine();
        recode(RESULT_MESSAGE);
    }

    public void recodeVictors(final List<Car> victors) {
        final String victorNames = victors.stream()
                .map(Car::getName)
                .collect(Collectors.joining(RacingGameOption.NAME_SEPARATOR));
        recode(String.format(VICTOR_MESSAGE, victorNames));
    }

    public void recode(final Visualizable recodeData) {
        recode(recodeData.visualize());
    }

    public void recode(final String recodeData) {
        recorder.append(recodeData);
        newLine();
    }

    @Override
    public String visualize() {
        return recorder.toString();
    }

    private void newLine() {
        recorder.append(StringUtils.NEW_LINE);
    }
}
