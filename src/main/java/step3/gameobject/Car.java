package step3.gameobject;

import step3.gameobject.rule.RaceRule;

public class Car {

    private static final String MARK = "-";
    private static final String DELIMITER_FOR_RESULT = " : ";

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String ERROR_MESSAGE_FOR_NAME_LENGTH_LIMIT = "자동차 이름은 5자를 초과할 수 없습니다.";

    private final String name;
    private final RaceRule raceRule;
    private String trace = MARK;

    public Car(String name, RaceRule raceRule) {
        this.checkName(name);
        this.name = name;
        this.raceRule = raceRule;
    }

    private void checkName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NAME_LENGTH_LIMIT);
        }
    }

    public void goOrStop() {
        if (raceRule.isMoved()) {
            plusTrace();
        }
    }

    private void plusTrace() {
        this.trace += MARK;
    }

    public String getNowRacingResult() {
        return name + DELIMITER_FOR_RESULT + trace;
    }

    public String getTrace() {
        return this.trace;
    }

    public String getName() {
        return this.name;
    }

}