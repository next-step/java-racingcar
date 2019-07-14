package homework.week1.racingcar.util;

import com.google.common.base.Strings;

public class ResultStringUtil {

    private static final String RUN_SYMBOL = "-";

    public static void printGuideStr(String guideStr) {
        System.out.println(guideStr);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static String makeCarRaceResultMessage(String carName, int position) {
        return carName  + " : " + ResultStringUtil.makeCarRaceImage(position, RUN_SYMBOL);
    }

    private static String makeCarRaceImage(int position, String repeatString) {
        return Strings.repeat(repeatString, position);
    }
}
