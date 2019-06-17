package com.jaeyeonling.racingcar.view;

import com.jaeyeonling.racingcar.utils.StringUtils;

public class VisualRecorder implements Visualizable {

    private final StringBuilder recorder = new StringBuilder();

    public void newLine() {
        recorder.append(StringUtils.NEW_LINE);
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
}
