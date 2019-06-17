package com.jaeyeonling.racingcar.view;

import com.jaeyeonling.racingcar.domain.Car;
import com.jaeyeonling.racingcar.domain.RacingGameOption;
import com.jaeyeonling.racingcar.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class VisualRecorder implements Visualizable {

    private final StringBuilder recorder = new StringBuilder();

    public void recodeResultMessage() {
        newLine();
        recode("실행 결과");
    }

    public void recodeVictors(final List<Car> victors) {
        final String victorNames = victors.stream()
                .map(Car::getName)
                .collect(Collectors.joining(RacingGameOption.NAME_SEPARATOR));
        recode(String.format("%s가 최종 우승했습니다.", victorNames));
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
