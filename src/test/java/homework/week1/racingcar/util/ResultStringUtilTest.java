package homework.week1.racingcar.util;

import org.junit.jupiter.api.Test;

public class ResultStringUtilTest {
    @Test
    void makeCarRaceResultMessage_printtest() {
        ResultStringUtil.printGuideStr(ResultStringUtil.makeCarRaceResultMessage("test", 5));
    }
}
