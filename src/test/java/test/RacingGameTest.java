package test;


import core.Cars;
import core.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("입력한 이름에 따른 자동차 생성 테스트")
    @Test
    void 자동차생성테스트() {
        Cars result = RacingGame.createCarList(new String[]{"carName1","carName2"});
        assertThat(result).extracting("name").contains("carName1","carName2");
    }
}

