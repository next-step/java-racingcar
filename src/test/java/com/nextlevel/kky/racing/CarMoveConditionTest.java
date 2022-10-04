package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.CarMoveCondition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarMoveConditionTest {

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:true", "9:true"}, delimiter = ':')
    void carMoveTest(int given, boolean expected) {
        CarMoveCondition carMoveCondition = new CarMoveCondition(() -> given);

        assertThat(carMoveCondition.checkMoveCondition()).isEqualTo(expected);
    }

    @Test
    void carMoveFailedTest() {
        assertThatThrownBy(() -> new CarMoveCondition(() -> 10).checkMoveCondition())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("not available value");
    }
}
