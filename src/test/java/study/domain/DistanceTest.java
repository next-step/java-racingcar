package study.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.calculator.Common.toInt;

class DistanceTest {

    @ParameterizedTest
    @CsvSource({"1,1","2,2","3,3","4,4","5,5"})
    void 거리입력(String input, String expected) {

        Distance distance = new Distance(toInt(input));
        assertThat(distance.getMove()).isEqualTo(toInt(expected));
    }
}