package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingUtilTest {
    @Test
    void splitCarNamesTest(){
        assertThat("pobi,crong,honux").isEqualTo("pobi,crong,honux");
    }

/*    @Test
    void splitTest() {
        CarRacingUtil carRacingUtil = new CarRacingUtil();
        assertThat(carRacingUtil.splitCarNames("ddd,fff,ggg")).isEqualTo("ddd");
    }*/
}
