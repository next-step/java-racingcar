package edu.nextstep.camp.racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingStartInputTest {

    @ParameterizedTest
    @CsvSource(value = {"1:9", "21:101", "-2:15", "3:-15", "test:12", "5:222#$"}, delimiter = ':')
    void racing_input_valid(String vehicleCnt, String movingCnt){
        Assertions.assertThatThrownBy(
                ()-> new RacingStartInput(vehicleCnt, movingCnt)
        ).isInstanceOf(RuntimeException.class);
    }

}
