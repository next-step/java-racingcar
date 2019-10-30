package racing;

import java.util.function.Function;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 17:16
 */
public enum  CarNextStep {
    GO("-"),
    STOP("");

    static Function<Integer, Boolean> moveStep = value -> value >= 4;
    private final String text;

    CarNextStep(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static CarNextStep getGoOrStop(int value) {
        return moveStep.apply(value) ? GO : STOP;
    }
}
