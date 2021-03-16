package step3.domain;

import step3.service.GameRule;

public class Car {
    private String racingLog = "";

    public String getRacingLog() {
        return racingLog;
    }

    public void move(GameRule rule) {
        if (rule.isMove()) {
            racingLog += "-";
        }
    }
}
