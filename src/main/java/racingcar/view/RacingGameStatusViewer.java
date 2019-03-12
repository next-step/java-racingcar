package racingcar.view;

import org.apache.commons.lang3.StringUtils;

public class RacingGameStatusViewer {

    private static final String POSITION_BAR = "-";

    public static void showStatus(int position) {
        System.out.println(StringUtils.repeat(POSITION_BAR, position+1));
    }

    public static void nextTurn() {
        System.out.println("");
    }
}
