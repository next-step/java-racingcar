package study.racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.racingCar.StringToIntConverter.stringToIntConverter;

class StringToIntConverterTest {

    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void converterTest (String str) {
        assertThat(stringToIntConverter(str)).isEqualTo(3);
    }

}